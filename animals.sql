-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Sep 07, 2019 at 12:22 PM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `android`
--

-- --------------------------------------------------------

--
-- Table structure for table `animals`
--

CREATE TABLE `animals` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `location` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `animals`
--

INSERT INTO `animals` (`id`, `name`, `location`) VALUES
(1, 'African WIld Dog', 'Africa'),
(2, 'Bat', 'Africa'),
(3, 'Lion ', 'Africa'),
(4, 'Tigers', 'Asia'),
(5, 'Kio Fish', 'Asia'),
(6, 'Parrots', 'S. America'),
(7, 'Leopards', 'S. America'),
(8, 'Wolves', 'N. America'),
(9, 'Moose', 'N. America'),
(10, 'Penguins', 'Antartica'),
(11, 'Whales', 'Antartica'),
(12, 'Seals', 'Antartica'),
(13, 'Big Bugs', 'S. America'),
(14, 'Pigeons', 'Europe'),
(15, 'Horses', 'Europe'),
(16, 'Sheep', 'Europe'),
(17, 'Giraffes', 'Africa'),
(18, 'Kangaroo', 'Australia'),
(19, 'Dingos', 'Australia'),
(20, 'Koala Bear', 'Australia');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `animals`
--
ALTER TABLE `animals`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `animals`
--
ALTER TABLE `animals`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
