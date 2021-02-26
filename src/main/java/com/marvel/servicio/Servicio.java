package com.marvel.servicio;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.*;

import org.json.JSONObject;

import com.marvel.database.Queries;
import com.marvel.model.Character;
import com.marvel.model.Creator;
import com.marvel.model.MainCharacter;
import com.marvel.requests.Request;

import org.json.JSONArray;

@Path("/marvel")
public class Servicio {

	private MainCharacter mainCharacter;

	@GET
	@Path("colaborators/ironman")
	public String colaborators() {

		/*
		 * getIronManData() proporciona el arreglo que incluye colaboradores que
		 * participaron en los comic del personaje.
		 */
		JSONArray arr = getIronManData();

		List<Creator> creatorsList = new ArrayList();

		for (Object obj : arr) {

			JSONObject jsonObject = (JSONObject) obj;

			/*
			 * Del arreglo proporcionado en getIronManData() obtenemos el título de cada
			 * comic, y un arreglo de colaboradores en el comic.
			 * 
			 */
			String comic = jsonObject.get("title").toString();
			JSONObject comicCreators = (JSONObject) jsonObject.get("creators");

			// Arreglo de colaboradores
			JSONArray creatorsArray = (JSONArray) comicCreators.get("items");

			/*
			 * Se recorre el arreglo de colaboradores, cada colaborador se guarda en la
			 * lista creatorsList.
			 */
			for (Object creator : creatorsArray) {
				JSONObject c = (JSONObject) creator;

				String name = c.get("name").toString();
				String role = c.get("role").toString();
				int idMainCharacter = mainCharacter.getId();

				if (!creatorsList.contains(name)) {
					Creator newCreator = new Creator(name, role, comic, idMainCharacter);
					creatorsList.add(newCreator);
				}

			}

		}

		// Enviamos la lista de colaboradores para guardar los datos en la DB
		Queries.insertCreator(creatorsList);

		return arr.toString();

	}

	@GET
	@Path("characters/ironman")
	public String characters() {

		/*
		 * getIronManData() proporciona el arreglo que incluye los personajes con los
		 * que el personaje ha interactuado
		 */
		JSONArray arr = getIronManData();

		List<Character> otherCharactersList = new ArrayList();

		for (Object obj : arr) {

			JSONObject jsonObject = (JSONObject) obj;

			/*
			 * Del arreglo proporcionado en getIronManData() obtenemos el título de cada
			 * comic, y un arreglo de personajes
			 * 
			 */
			String comic = jsonObject.get("title").toString();
			JSONObject characters = (JSONObject) jsonObject.get("characters");

			// Arreglo de personajes
			JSONArray charactersArray = (JSONArray) characters.get("items");

			/*
			 * Se recorre el arreglo de personajes, cada personaje se guarda en la lista
			 * otherCharactersList.
			 */
			for (Object character : charactersArray) {
				JSONObject c = (JSONObject) character;

				String name = c.get("name").toString();

				if (!otherCharactersList.contains(name)) {
					System.out.println(mainCharacter.getId());
					Character newCharacter = new Character(name, comic, mainCharacter.getId());
					otherCharactersList.add(newCharacter);
				}

			}

		}

		// Enviamos la lista de personajes para guardar los datos en la DB
		Queries.insertOtherCharacter(otherCharactersList);

		return arr.toString();

	}

	private JSONArray getIronManData() {

		JSONObject jsonObject = null;
		JSONArray arr = null;
		Request get = new Request();
		Properties props = new Properties();
		ResultSet rs = null;

		/*
		 * Input Stream donde leemos el recurso donde está el archivo de propiedades que
		 * incluye una url base y claves api_key y hash
		 */
		InputStream is = Servicio.class.getClassLoader().getResourceAsStream("custom.properties");

		try {
			props.load(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// URL para llamar al API de Marvel
		String urlGetIronManId = props.getProperty("base_url") + "ts=100&apikey=" + props.getProperty("api_key")
				+ "&hash=" + props.getProperty("hash_urlGetIronManId");

		// Obtenemos un objeto json con los datos del personaje
		jsonObject = get.request(urlGetIronManId);// request() contiene el código para llamar el API de Marvel
		jsonObject = (JSONObject) jsonObject.get("data");
		arr = (JSONArray) jsonObject.get("results");
		jsonObject = (JSONObject) arr.get(0);

		// instanciamos mainCharacter para guardar los datos del personaje y guardar sus
		// datos en la DB
		mainCharacter = new MainCharacter(Integer.parseInt(jsonObject.get("id").toString()),
				jsonObject.get("name").toString());
		mainCharacter = Queries.insertMainCharacter(mainCharacter);

		// Del onbjeto jsonObject obtenemos una url con la colección de comics en los
		// que aparece el personaje
		jsonObject = (JSONObject) jsonObject.get("comics");
		String collectionURI = jsonObject.get("collectionURI").toString();

		/*
		 * URL de llamada al API de Marvel, esta proporcionara un arreglo con la
		 * colección de comics los comics en donde aparce el personaje, así como los
		 * colaboradores del comic y otros personajes
		 */
		String urlIronManComicsCollection = collectionURI + "?ts=200&apikey=" + props.getProperty("api_key") + "&hash="
				+ props.getProperty("hash_urlIronManComicsCollection");

		// obtenemos el arreglo con la colección de comics
		jsonObject = get.request(urlIronManComicsCollection); // request() contiene el código para llamar el API de
																// Marvel
		jsonObject = (JSONObject) jsonObject.get("data");
		arr = (JSONArray) jsonObject.get("results");

		return arr;
	}

}
