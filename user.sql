-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2020 at 02:15 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gaming`
--

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `Uid` int(30) NOT NULL,
  `first` varchar(30) NOT NULL,
  `lname` varchar(15) NOT NULL,
  `email` varchar(30) NOT NULL,
  `age` int(3) NOT NULL,
  `mobile` int(10) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`Uid`, `first`, `lname`, `email`, `age`, `mobile`, `password`) VALUES
(12, 'Anne', 'Marie', 'Annegmail@gmail.com', 25, 761490324, 'zzzzsAAqz'),
(13, 'Don', 'Nadeesha', 'donnadeesha12@gmail.com', 22, 772105439, 'gfsggh21h'),
(19, 'tani', 'silva', 'tsilva@gmail', 26, 702045632, '203wqa'),
(22, 'Nadeesha', 'Abcdef', 'nm@gmail', 23, 774598145, '1998'),
(23, 'don', 'boya', 'dd@40gmail', 19, 764598188, '2000'),
(24, 'alex', 'standol', 'alex@gmail', 22, 764598250, '2020'),
(25, 'Hannah', 'Baker', 'hann@gmail', 23, 994598258, '2017'),
(27, 'Data', 'Boyy', 'Dtb@gmail', 25, 777444558, '2050'),
(29, 'dfdf', 'bb', 'abc@40123', 14, 555555, 'hhhh'),
(32, 'GG', 'TT', 'DFC@gmail.com', 23, 444455514, 'bbb'),
(33, 'Update', 'up', 'toto@gmail.com', 33, 40404040, 'hghgh'),
(36, 'final', 'insert', 'final@gmail.com', 23, 115547913, 'Nadeesha'),
(37, 'test', 'Update+', 'updateddd@gmail.com', 26, 444555123, 'cbvnm'),
(38, 'ags', 'ddijwj', 'g@gmail.com', 21, 222333183, 'wdwjd'),
(39, 'viva', 'test', 'viva@gmail.com', 12, 111254987, 'okaybro');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`Uid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `Uid` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
