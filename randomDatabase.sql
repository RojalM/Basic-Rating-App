-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
-- Erstellungszeit: 15. Jan 2022 um 16:23
-- Server-Version: 10.4.22-MariaDB
-- PHP-Version: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `randomDatabase`
--

-- --------------------------------------------------------

--
-- Table structure for `moviedatabase`
--

CREATE TABLE `moviedatabase` (
  `Titel` varchar(50) NOT NULL,
  `Veröffentlichungsdatum` date NOT NULL,
  `Direktor` varchar(50) NOT NULL,
  `Hauptdarsteller` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `moviedatabase`
--

INSERT INTO `moviedatabase` (`Titel`, `Veröffentlichungsdatum`, `Direktor`, `Hauptdarsteller`) VALUES
('Big Bang', '1984-02-13', 'Bartha, John', 'Amir'),
('can you be me', '1989-11-17', 'Barthelmess, Richard ', 'Timo'),
('Car draw', '2000-08-18', 'Tomas Han', 'Carolin'),
('Current', '1953-05-12', 'Bartilson, Matth', 'Karim'),
('eteat', '2022-01-15', 'eteat', 'etet'),
('eXistenZ', '1949-07-01', 'T Barton, Charles', 'Anno'),
('Final day', '2010-06-11', 'Bartilson, Matth', 'Sasha'),
('how can you', '1975-09-15', 'Bartha, John', 'Anna'),
('how dare you', '1940-11-08', 'Tomas Han', 'Sara'),
('i am not dead', '1978-12-04', 'Bartha, John', 'Sarib'),
('life is not easy', '1939-07-07', 'Bartholomew Jr., Sydney J.', 'Haya'),
('Love is true', '1969-02-26', 'Barton, Rodger', 'Werner'),
('Money is Life', '1976-01-19', 'Bartholomew Jr., Sydney J.', 'Saskia'),
('Mortal Combat', '1988-04-02', 'Bartell, Tim  ', 'Esabil'),
('My Car', '1946-05-03', 'Zucker, Danielle   ', 'kolavisc'),
('Saw me !', '1989-11-04', 'Bartel, Paul (I)', 'Mariam'),
('sdaf', '2022-01-15', 'sad', 'asd'),
('So we try', '1949-10-24', 'Barton, Rodger', 'Wagner'),
('The Cat', '1995-03-10', 'Bartel, José  ', 'Rawan'),
('the crying kid', '1945-03-18', ' Bartha, Justin ', 'Catrin'),
('the dead things', '2002-05-19', 'Bartha, John', 'Marita'),
('The End', '1975-01-11', 'Tomas Han', 'Martin'),
('The last of us', '1964-10-01', 'Tomas Han', 'John'),
('The Real Man', '1969-04-12', ' Bart, Pete', 'Kim'),
('The Rest of me', '1989-05-12', 'Bartell, Eddie', 'Danny'),
('the Thing', '1991-03-23', 'Bartel, José   ', 'Samid'),
('This', '1953-08-17', 'Tomas Han', 'Tomas'),
('Where are we', '1994-05-22', 'Barsky, Vladimir ', 'John'),
('Why you see me', '2006-02-06', 'Barth, Bruce David  ', 'Max'),
('Yôjinbô', '1910-11-19', 'Laporta', 'Jim Carry'),
('Zeus and Roxanne', '1910-04-02', 'Marry', 'carop'),
('Zeus2', '1932-02-17', 'Bartilson, Matth', 'Alex'),
('Zone 39', '1997-02-10', 'Tom', 'salid');

-- --------------------------------------------------------

--
-- Table structure for `ratings`
--

CREATE TABLE `ratings` (
  `username` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `Movie` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `rating` int(10) NOT NULL,
  `Comment` text CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Table structure for `ratings`
--

INSERT INTO `ratings` (`username`, `Movie`, `rating`, `Comment`) VALUES
('philipp_kgr', 'Big Bang', 10, ''),
('philipp_kgr', 'Zeus2', 10, 'asd'),
('sophkrue', 'Big Bang', 5, 'asd'),
('test', 'test', 5, 'as'),
('tschukke', 'Big Bang', 5, 'asd'),
('weedsmoker011', 'Big Bang', 3, '');

-- --------------------------------------------------------

--
-- Table structure for `userdatabase`
--

CREATE TABLE `userdatabase` (
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `age` int(99) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for `userdatabase`
--

INSERT INTO `userdatabase` (`username`, `email`, `age`) VALUES
('asdgh', 'ghjkh', 20),
('asw3r', 'wqrt', 20),
('bmnbm', 'bnmm', 21),
('iop', 'opiopi', 88),
('sadgh', 'hfgjgj', 23),
('test', 'test', 20),
('test2', 'mailmail.de', 20),
('tschukke', 'tschukke@tschukkemail.com', 18),
('vbnbnv', 'nbv,', 88);

--
-- Indexes of the exported tables
--

--
-- Indexes for the table `moviedatabase`
--
ALTER TABLE `moviedatabase`
  ADD PRIMARY KEY (`Titel`);

--
-- Indexes for the table `ratings`
--
ALTER TABLE `ratings`
  ADD PRIMARY KEY (`username`(255),`Movie`(255));

--
-- Indexes for the table `userdatabase`
--
ALTER TABLE `userdatabase`
  ADD PRIMARY KEY (`username`),
  ADD UNIQUE KEY `email` (`email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
