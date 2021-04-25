-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2021 at 04:20 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `paf_project`
--

-- --------------------------------------------------------

--
-- Table structure for table `buyers`
--

CREATE TABLE `buyers` (
  `BuyerID` int(10) NOT NULL,
  `Name` varchar(60) NOT NULL,
  `Email` varchar(65) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `ContactNumber` varchar(10) NOT NULL,
  `NameOnCard` varchar(10) NOT NULL,
  `CreditCardNumber` varchar(20) NOT NULL,
  `ExpiryDate` varchar(20) NOT NULL,
  `CVV` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `buyers`
--

INSERT INTO `buyers` (`BuyerID`, `Name`, `Email`, `Address`, `ContactNumber`, `NameOnCard`, `CreditCardNumber`, `ExpiryDate`, `CVV`) VALUES
(1, 'Thimira Isiwara', 'thimiraisiwara98@gmail.com', 'no 77/8, udugama road, makuluwa, galle', '0719798300', 'BOC', '2347 5678 4537 6734', '2021/12/31', '134'),
(2, 'dhammika guruge', 'dhamika19se@gmail.com', 'no 21, kollupitiya road, bambalapitiya', '0715673456', 'BOC', '2342 6789 4567 2345', '2022/09/19', '494'),
(3, 'tharusha nethmina', 'tharumuthu@gmail.com', 'no 8, akuressa road, mathara', '0913678478', 'Sampath', '3456 2345 7234 7890', '2022/01/31', '623'),
(4, 'pasindu lakshitha', 'pasindu1996@gmail.com', 'no 222/B, theldeniya road, peraadeniya, kandy', '0918347449', 'NSB', '2678 3245 7834 6209', '2023/12/31', '724');

-- --------------------------------------------------------

--
-- Table structure for table `reg_user`
--

CREATE TABLE `reg_user` (
  `User_ID` int(11) NOT NULL,
  `User_name` varchar(50) NOT NULL,
  `User_address` varchar(50) NOT NULL,
  `User_gender` varchar(7) NOT NULL,
  `User_age` int(11) NOT NULL,
  `User_title` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reg_user`
--

INSERT INTO `reg_user` (`User_ID`, `User_name`, `User_address`, `User_gender`, `User_age`, `User_title`) VALUES
(15, 'A.A. Perera', '57, Kottawa Road, Maharagama', 'Male', 33, 'Researcher');

-- --------------------------------------------------------

--
-- Table structure for table `requirement`
--

CREATE TABLE `requirement` (
  `reqId` int(11) NOT NULL,
  `reqNote` varchar(45) NOT NULL,
  `reqType` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `research`
--

CREATE TABLE `research` (
  `Res_ID` int(11) NOT NULL,
  `Res_type` varchar(45) NOT NULL,
  `Res_note` varchar(240) NOT NULL,
  `Res_price` varchar(45) NOT NULL,
  `Ruser_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `research`
--

INSERT INTO `research` (`Res_ID`, `Res_type`, `Res_note`, `Res_price`, `Ruser_ID`) VALUES
(2, 'tech', 'drone system', '5000', 1);

-- --------------------------------------------------------

--
-- Table structure for table `review_management`
--

CREATE TABLE `review_management` (
  `ResearchProject_ID` int(11) NOT NULL,
  `RP_Name` varchar(50) NOT NULL,
  `RP_StarRate` int(5) NOT NULL,
  `RP_Feedback` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `review_management`
--

INSERT INTO `review_management` (`ResearchProject_ID`, `RP_Name`, `RP_StarRate`, `RP_Feedback`) VALUES
(44, 'Machine Learning', 4, 'Importance of machine learning');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buyers`
--
ALTER TABLE `buyers`
  ADD PRIMARY KEY (`BuyerID`);

--
-- Indexes for table `reg_user`
--
ALTER TABLE `reg_user`
  ADD PRIMARY KEY (`User_ID`);

--
-- Indexes for table `requirement`
--
ALTER TABLE `requirement`
  ADD PRIMARY KEY (`reqId`);

--
-- Indexes for table `research`
--
ALTER TABLE `research`
  ADD PRIMARY KEY (`Res_ID`);

--
-- Indexes for table `review_management`
--
ALTER TABLE `review_management`
  ADD PRIMARY KEY (`ResearchProject_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `buyers`
--
ALTER TABLE `buyers`
  MODIFY `BuyerID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `reg_user`
--
ALTER TABLE `reg_user`
  MODIFY `User_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `requirement`
--
ALTER TABLE `requirement`
  MODIFY `reqId` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
