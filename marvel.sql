-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 26, 2021 at 07:27 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `marvel`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_creator` (IN `name_creator` VARCHAR(45), IN `rol_creator` VARCHAR(45), IN `comic_creator` VARCHAR(200), IN `id_main_character` VARCHAR(45))  BEGIN
	IF NOT EXISTS ( SELECT name FROM marvel.creators WHERE name = name_creator ) THEN
		BEGIN
		  INSERT INTO marvel.creators (name,rol,comic,id_character) VALUES (name_creator,rol_creator,comic_creator,id_main_character);
		END;
    END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_main_character` (IN `id` INT, IN `name_character` VARCHAR(45))  BEGIN
    IF NOT EXISTS ( SELECT id_api FROM marvel.character WHERE id_api = id  ) THEN
		BEGIN
		  INSERT INTO marvel.character (id_api,name) VALUES (id, name_character) ;
		END;
    END IF;
    SELECT * FROM marvel.character;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_other_character` (IN `name_character` VARCHAR(45), IN `comic_character` VARCHAR(200), IN `id_main_character` VARCHAR(45))  BEGIN
    IF NOT EXISTS ( SELECT name FROM marvel.other_characters WHERE name = name_character  ) THEN
		BEGIN
		  INSERT INTO marvel.other_characters (name,comic,id_character) VALUES (name_character,comic_character,id_main_character);
		END;
    END IF;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `character`
--

CREATE TABLE `character` (
  `id` int(11) NOT NULL,
  `id_api` int(11) NOT NULL,
  `name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `character`
--

INSERT INTO `character` (`id`, `id_api`, `name`) VALUES
(10, 1009368, 'Iron Man');

-- --------------------------------------------------------

--
-- Table structure for table `creators`
--

CREATE TABLE `creators` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `rol` varchar(45) NOT NULL,
  `comic` varchar(200) DEFAULT NULL,
  `id_character` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `creators`
--

INSERT INTO `creators` (`id`, `name`, `rol`, `comic`, `id_character`) VALUES
(233, 'Jeff Youngquist', 'editor', 'Wolverine Saga (2009) #7', 10),
(234, 'Tom Brevoort', 'editor', 'Iron Man (2020) #6', 10),
(235, 'C Cafu', 'inker', 'Iron Man (2020) #6', 10),
(236, 'Christopher Cantwell', 'writer', 'Iron Man (2020) #6', 10),
(237, 'Vc Joe Caramagna', 'letterer', 'Iron Man (2020) #6', 10),
(238, 'Frank D\'ARMATA', 'colorist', 'Iron Man (2020) #6', 10),
(239, 'Alex Ross', 'painter (cover)', 'Iron Man (2020) #6', 10),
(240, 'Guru Efx', 'colorist (cover)', 'King In Black: Iron Man/Doom (2020) #1', 10),
(241, 'Vc Travis Lanham', 'letterer', 'King In Black: Iron Man/Doom (2020) #1', 10),
(242, 'Salvador Larroca', 'penciler (cover)', 'King In Black: Iron Man/Doom (2020) #1', 10),
(243, 'Kurt Busiek', 'writer', 'Avengers: Marvels Snapshots (2020) #1', 10),
(244, 'Barbara Kesel', 'writer', 'Avengers: Marvels Snapshots (2020) #1', 10),
(245, 'Jim Charalampidis', 'colorist', 'Avengers: Marvels Snapshots (2020) #1', 10),
(246, 'Staz Johnson', 'penciler', 'Avengers: Marvels Snapshots (2020) #1', 10),
(247, 'Vc Ariana Maher', 'letterer', 'Avengers: Marvels Snapshots (2020) #1', 10),
(248, 'Tom Palmer', 'inker', 'Avengers: Marvels Snapshots (2020) #1', 10),
(249, 'Sweeney Boo', 'penciller (cover)', 'Marvel Action Chillers (2020) #1', 10),
(250, 'Jeremy Whitley', 'writer', 'Marvel Action Chillers (2020) #1', 10),
(251, 'Federico Blee', 'colorist', 'Aero (2019) #12', 10),
(252, 'Pop Mhan', 'inker', 'Aero (2019) #12', 10),
(253, 'Xu Ming', 'penciler (cover)', 'Aero (2019) #12', 10),
(254, 'Greg Pak', 'writer', 'Aero (2019) #12', 10),
(255, 'Alyssa Wong', 'writer', 'Aero (2019) #12', 10),
(256, 'Mark Paniccia', 'editor', 'Aero (2019) #12', 10),
(257, 'Donny Cates', 'writer', 'Thor (2020) #8', 10),
(258, 'Olivier Coipel', 'penciler (cover)', 'Thor (2020) #8', 10),
(259, 'Aaron Kuder', 'inker', 'Thor (2020) #8', 10),
(260, 'Laura Martin', 'colorist (cover)', 'Thor (2020) #8', 10),
(261, 'Wilson Moss', 'editor', 'Thor (2020) #8', 10),
(262, 'Vc Joe Sabino', 'letterer', 'Thor (2020) #8', 10),
(263, 'Matthew Wilson', 'colorist', 'Thor (2020) #8', 10),
(264, 'Marco Checchetto', 'penciler (cover)', 'Daredevil (2019) #22', 10),
(265, 'Vc Clayton Cowles', 'letterer', 'Daredevil (2019) #22', 10),
(266, 'Mattia Iacono', 'colorist', 'Daredevil (2019) #22', 10),
(267, 'Edward Devin Lewis', 'editor', 'Daredevil (2019) #22', 10),
(268, 'Francesco Mobili', 'penciler', 'Daredevil (2019) #22', 10),
(269, 'Victor Olazaba', 'inker', 'Daredevil (2019) #22', 10),
(270, 'Nolan Woodard', 'colorist (cover)', 'Daredevil (2019) #22', 10),
(271, 'Chip Zdarsky', 'writer', 'Daredevil (2019) #22', 10),
(272, 'Michael Kelleher', 'colorist', 'Tales of Suspense Facsimile Edition (2020) #39', 10),
(273, 'Amy Chu', 'writer', 'Aero (2019) #11', 10),
(274, 'J. Scott Campbell', 'penciler (cover)', 'Black Cat (2019) #12', 10),
(275, 'Ferran Delgado', 'letterer', 'Black Cat (2019) #12', 10),
(276, 'Nick Lowe', 'editor', 'Black Cat (2019) #12', 10),
(277, 'Jed Mackay', 'writer', 'Black Cat (2019) #12', 10),
(278, 'Brian Reber', 'colorist', 'Black Cat (2019) #12', 10),
(279, 'Sabine Rich', 'colorist (cover)', 'Black Cat (2019) #12', 10),
(280, 'Carlos Villa', 'inker', 'Black Cat (2019) #12', 10),
(281, 'Christos Gage', 'writer', 'Iron Man 2020 (2020) #5', 10),
(282, 'Dan Slott', 'writer', 'Iron Man 2020 (2020) #5', 10),
(283, 'Peter M. Woods', 'penciler (cover)', 'Iron Man 2020 (2020) #5', 10),
(284, 'Iban Coello', 'penciler', 'Free Comic Book Day: X-Men (2020) #1', 10),
(285, 'Marte Gracia', 'colorist (cover)', 'Free Comic Book Day: X-Men (2020) #1', 10),
(286, 'Jonathan Hickman', 'writer', 'Free Comic Book Day: X-Men (2020) #1', 10),
(287, 'Tom Taylor', 'writer', 'Free Comic Book Day: X-Men (2020) #1', 10),
(288, 'Pepe Larraz', 'penciler (cover)', 'Free Comic Book Day: X-Men (2020) #1', 10),
(289, 'Jordan White', 'editor', 'Free Comic Book Day: X-Men (2020) #1', 10),
(290, 'Peter Steigerwald', 'colorist (cover)', 'Black Cat (2019) #11', 10);

-- --------------------------------------------------------

--
-- Table structure for table `other_characters`
--

CREATE TABLE `other_characters` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `comic` varchar(200) DEFAULT NULL,
  `id_character` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `other_characters`
--

INSERT INTO `other_characters` (`id`, `name`, `comic`, `id_character`) VALUES
(43, 'Iron Man', 'Wolverine Saga (2009) #7', 10),
(44, 'Wolverine', 'Wolverine Saga (2009) #7', 10),
(45, 'Hellcat (Patsy Walker)', 'Iron Man (2020) #6', 10),
(46, 'Misty Knight', 'Iron Man (2020) #6', 10),
(47, 'Doctor Doom', 'King In Black: Iron Man/Doom (2020) #1', 10),
(48, 'Thor', 'Thor (2020) #8', 10),
(49, 'Daredevil', 'Daredevil (2019) #22', 10),
(50, 'Beta-Ray Bill', 'Thor (2020) #7', 10),
(51, 'Black Cat', 'Black Cat (2019) #12', 10),
(52, 'Magik (Illyana Rasputin)', 'Free Comic Book Day: X-Men (2020) #1', 10),
(53, 'Nightcrawler', 'Free Comic Book Day: X-Men (2020) #1', 10),
(54, 'Rogue', 'Free Comic Book Day: X-Men (2020) #1', 10),
(55, 'Storm', 'Free Comic Book Day: X-Men (2020) #1', 10),
(56, 'X-Men', 'Free Comic Book Day: X-Men (2020) #1', 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `character`
--
ALTER TABLE `character`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `creators`
--
ALTER TABLE `creators`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_creators_character_idx` (`id_character`);

--
-- Indexes for table `other_characters`
--
ALTER TABLE `other_characters`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_other_characters_character1_idx` (`id_character`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `character`
--
ALTER TABLE `character`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `creators`
--
ALTER TABLE `creators`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=291;

--
-- AUTO_INCREMENT for table `other_characters`
--
ALTER TABLE `other_characters`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `creators`
--
ALTER TABLE `creators`
  ADD CONSTRAINT `fk_creators_character` FOREIGN KEY (`id_character`) REFERENCES `character` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `other_characters`
--
ALTER TABLE `other_characters`
  ADD CONSTRAINT `fk_other_characters_character1` FOREIGN KEY (`id_character`) REFERENCES `character` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
