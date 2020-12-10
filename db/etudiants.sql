-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : Dim 29 mars 2020 à 13:24
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.4.2
-- Auteur: Eya Zaoui, RT 2-1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `etudiants`
--

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `Id` int(11) NOT NULL,
  `Nom` varchar(20) NOT NULL,
  `DateDeNaissance` date NOT NULL,
  `Nationalite` varchar(20) NOT NULL,
  `Email` varchar(20) NOT NULL,
  `Adresse` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`Id`, `Nom`, `DateDeNaissance`, `Nationalite`, `Email`, `Adresse`) VALUES
(1800234, 'Madeline Dubois', '2000-06-06', 'Française', 'M.Dubois@hotmail.fr', '9 rue Palestine Tunis'),
(1800467, 'Eya Zaoui', '1999-07-20', 'Tunisienne', 'zaouieya@gmail.com', '14 rue 10469 Ariana'),
(1800568, 'Ahmed Samir', '1998-03-14', 'Tunisienne', 'ahmeds@yahoo.fr', '2 rue Les Jasmins Manzah 1');


ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
