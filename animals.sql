-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Sep 16, 2019 at 05:10 PM
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
  `location` varchar(100) NOT NULL,
  `img` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `animals`
--

INSERT INTO `animals` (`id`, `name`, `location`, `img`) VALUES
(1, 'African WIld Dog', 'Africa', 'www.android.com/searchRv/african-wild-dog.jpg'),
(2, 'Bat', 'Africa', 'www.android.com/searchRv/bat.jpg'),
(3, 'Lion ', 'Africa', 'www.android.com/searchRv/lion.jpeg'),
(4, 'Tigers', 'Asia', 'www.android.com/searchRv/tiger.jpeg'),
(5, 'Kio Fish', 'Asia', 'www.android.com/searchRv/kio-fish.jpeg'),
(6, 'Parrots', 'S. America', 'www.android.com/searchRv/parrot.jpeg'),
(7, 'Leopards', 'S. America', 'www.android.com/searchRv/leopard.jpeg'),
(8, 'Wolves', 'N. America', 'www.android.com/searchRv/wolf.jpeg'),
(9, 'Moose', 'N. America', 'www.android.com/searchRv/mose.jpeg'),
(10, 'Penguins', 'Antartica', 'www.android.com/searchRv/penguin.jpeg'),
(11, 'Whales', 'Antartica', 'www.android.com/searchRv/whale.jpeg'),
(12, 'Seals', 'Antartica', 'www.android.com/searchRv/seal.jpeg'),
(13, 'Big Bugs', 'S. America', 'www.android.com/searchRv/big-bugs.jpg'),
(14, 'Pigeons', 'Europe', 'www.android.com/searchRv/pegion.jpeg'),
(15, 'Horses', 'Europe', 'www.android.com/searchRv/horse.jpeg'),
(16, 'Sheep', 'Europe', 'www.android.com/searchRv/sheep.jpeg'),
(17, 'Giraffes', 'Africa', 'www.android.com/searchRv/giraffe.jpeg'),
(18, 'Kangaroo', 'Australia', 'www.android.com/searchRv/kangaroo.jpeg'),
(19, 'Dingos', 'Australia', 'www.android.com/searchRv/dingo.jpeg'),
(20, 'Koala Bear', 'Australia', 'www.android.com/searchRv/koala.jpeg');

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
