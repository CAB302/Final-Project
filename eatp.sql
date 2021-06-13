-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 13, 2021 at 12:04 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `eatp`
--

-- --------------------------------------------------------

--
-- Table structure for table `asset_type`
--

CREATE TABLE `asset_type` (
  `id` int(11) NOT NULL,
  `asset_names` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `asset_type`
--

INSERT INTO `asset_type` (`id`, `asset_names`) VALUES
(1, 'MeowNeow');

-- --------------------------------------------------------

--
-- Table structure for table `current_trades`
--

CREATE TABLE `current_trades` (
  `id` int(11) NOT NULL,
  `organisational_unit` text NOT NULL,
  `asset_name` text NOT NULL,
  `quantity` text NOT NULL,
  `price` text NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `current_trades`
--

INSERT INTO `current_trades` (`id`, `organisational_unit`, `asset_name`, `quantity`, `price`, `timestamp`) VALUES
(1, 'asdu', 'asdn', 'asdq', 'asdp', '2021-06-13 09:56:24'),
(2, 'asd', 'asd', 'asd', 'asd', '2021-06-13 10:03:00');

-- --------------------------------------------------------

--
-- Table structure for table `organisational_unit_information`
--

CREATE TABLE `organisational_unit_information` (
  `id` int(11) NOT NULL,
  `organisational_unit_name` text NOT NULL,
  `credits` text NOT NULL,
  `assets` text DEFAULT NULL,
  `quantity` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `organisational_unit_information`
--

INSERT INTO `organisational_unit_information` (`id`, `organisational_unit_name`, `credits`, `assets`, `quantity`) VALUES
(1, 'asd', 'asd', 'def', 'def'),
(2, 'wer', 'wer', 'def', 'def'),
(3, 'Hey', 'You', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user_information`
--

CREATE TABLE `user_information` (
  `id` int(11) NOT NULL,
  `username` text DEFAULT NULL,
  `password` text DEFAULT NULL,
  `account_type` text DEFAULT NULL,
  `organisational_unit` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_information`
--

INSERT INTO `user_information` (`id`, `username`, `password`, `account_type`, `organisational_unit`) VALUES
(9, 'user', '1', 'user', 'Here'),
(11, 'asd', '2', 'admin', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `asset_type`
--
ALTER TABLE `asset_type`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `current_trades`
--
ALTER TABLE `current_trades`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `organisational_unit_information`
--
ALTER TABLE `organisational_unit_information`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_information`
--
ALTER TABLE `user_information`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `asset_type`
--
ALTER TABLE `asset_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `current_trades`
--
ALTER TABLE `current_trades`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `organisational_unit_information`
--
ALTER TABLE `organisational_unit_information`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user_information`
--
ALTER TABLE `user_information`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
