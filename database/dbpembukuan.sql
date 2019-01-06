-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 05, 2019 at 01:03 PM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbpembukuan`
--

-- --------------------------------------------------------

--
-- Table structure for table `detail_sawah`
--

CREATE TABLE `detail_sawah` (
  `id_detail_sawah` int(11) NOT NULL,
  `id_sawah` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `keterangan` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  `besar` varchar(50) NOT NULL,
  `tanggal` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detail_sawah`
--

INSERT INTO `detail_sawah` (`id_detail_sawah`, `id_sawah`, `nama`, `keterangan`, `status`, `besar`, `tanggal`) VALUES
(1, 2, 'beli obat', 'onat hijau biru merah', 'keluar', '100000', '2019-01-05 05:37:01'),
(2, 2, 'beli pupuk', 'pupuk npk 10 ton', 'keluar', '2000', '2019-01-05 05:37:47'),
(3, 2, 'jual rumput', '1 hektar', 'masuk', '100', '2019-01-05 05:37:47'),
(4, 2, 'jual jagung bakar', '2 hektar', 'masuk', '1000000', '2019-01-05 05:37:47'),
(5, 2, 'sewa truk', 'angkut jagung bakar', 'keluar', '5000', '2019-01-05 05:37:47');

-- --------------------------------------------------------

--
-- Table structure for table `jenis_tanaman`
--

CREATE TABLE `jenis_tanaman` (
  `id_jenis_tanaman` int(11) NOT NULL,
  `jenis_tanaman` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jenis_tanaman`
--

INSERT INTO `jenis_tanaman` (`id_jenis_tanaman`, `jenis_tanaman`) VALUES
(1, 'jagung'),
(2, 'padi'),
(3, 'tebu'),
(4, 'kedelai'),
(5, 'jeruk');

-- --------------------------------------------------------

--
-- Table structure for table `sawah`
--

CREATE TABLE `sawah` (
  `id_sawah` int(11) NOT NULL,
  `nama_sawah` varchar(50) NOT NULL,
  `biaya_sewa` varchar(50) NOT NULL DEFAULT '0',
  `alamat` varchar(50) NOT NULL,
  `id_jenis_tanaman` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sawah`
--

INSERT INTO `sawah` (`id_sawah`, `nama_sawah`, `biaya_sewa`, `alamat`, `id_jenis_tanaman`) VALUES
(1, 'sawah 1', '100000', 'jember', '2'),
(2, 'nama update', '100', 'jember mana', 'jagung'),
(3, 'sawah 123', '123', '123', '0'),
(4, 'a', '1', '1', '0'),
(5, 'a', '1', '1', 'jagung'),
(6, 'a', '1', '1', 'jagung'),
(7, 'a', '1', '1', 'jagung'),
(8, 'a', '1', '1', 'jagung'),
(9, 'a', '1', '1', 'jagung'),
(10, 'a', '100', '1', 'jagung'),
(11, 'a', '1', '1', 'jagung'),
(12, 'a', '1', '1', 'jagung'),
(13, 'a', '1', '1', 'jagung'),
(14, '2', 'nama update', '100', 'jember ma'),
(15, '6', 'a', '100', '1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `detail_sawah`
--
ALTER TABLE `detail_sawah`
  ADD PRIMARY KEY (`id_detail_sawah`);

--
-- Indexes for table `jenis_tanaman`
--
ALTER TABLE `jenis_tanaman`
  ADD PRIMARY KEY (`id_jenis_tanaman`);

--
-- Indexes for table `sawah`
--
ALTER TABLE `sawah`
  ADD PRIMARY KEY (`id_sawah`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `detail_sawah`
--
ALTER TABLE `detail_sawah`
  MODIFY `id_detail_sawah` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `jenis_tanaman`
--
ALTER TABLE `jenis_tanaman`
  MODIFY `id_jenis_tanaman` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `sawah`
--
ALTER TABLE `sawah`
  MODIFY `id_sawah` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
