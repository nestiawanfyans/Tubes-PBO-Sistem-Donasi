-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Waktu pembuatan: 18 Bulan Mei 2020 pada 18.33
-- Versi server: 10.4.11-MariaDB
-- Versi PHP: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `donasi-tubes-pbo`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `bayarDonasi`
--

CREATE TABLE `bayarDonasi` (
  `id` int(11) NOT NULL,
  `id_user` int(11) DEFAULT NULL,
  `id_donasi` int(11) DEFAULT NULL,
  `jumlahDonasi` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `bayarDonasi`
--

INSERT INTO `bayarDonasi` (`id`, `id_user`, `id_donasi`, `jumlahDonasi`) VALUES
(1, 1, 2, 10000),
(2, 1, 2, 500000),
(3, 1, 2, 100000),
(4, 1, 2, 0),
(5, 1, 2, 50000),
(6, 1, 2, 1000000),
(7, 1, 2, 250000),
(8, 1, 3, 30000),
(9, 1, 2, 3000000),
(10, 1, 1, 50000),
(11, 1, 2, 50000),
(12, 1, 3, 534343),
(13, 1, 1, 20000),
(14, 1, 1, 50000),
(15, 1, 3, 100000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `dataDonasi`
--

CREATE TABLE `dataDonasi` (
  `id` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `id_user` varchar(100) NOT NULL,
  `targetDonasi` int(11) NOT NULL,
  `masaBerakhir` date NOT NULL,
  `deskripsi` longtext NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `dataDonasi`
--

INSERT INTO `dataDonasi` (`id`, `title`, `id_user`, `targetDonasi`, `masaBerakhir`, `deskripsi`, `created_at`) VALUES
(1, 'beli pc gan ', 'saya', 4000000, '2020-05-20', 'donasi geh ', '2020-05-18 06:08:30'),
(2, 'bantu emak gan', 'saya sendiri', 5000000, '2020-05-20', 'bantu geh gan jangan pelit.', '2020-05-18 13:02:59'),
(3, 'bantu mak ijah bro', 'bapaknya ijah', 10000, '2020-05-21', 'bantu geh gan jangan pelit.', '2020-05-18 13:03:19');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `username` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id`, `nama`, `username`, `email`, `password`) VALUES
(1, 'nestiawan', 'perdi', 'nestiawan@gmail.com', '123'),
(2, 'nestiawan2', 'nestiawanaja', 'nestiawan@gmail.com', '123123'),
(3, 'Nestiawan Ferdiyanto', 'nestiawan', 'p.nestiawan123321@gmail.com', 'perdi321'),
(4, '', '', '', '');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `bayarDonasi`
--
ALTER TABLE `bayarDonasi`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `dataDonasi`
--
ALTER TABLE `dataDonasi`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `bayarDonasi`
--
ALTER TABLE `bayarDonasi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT untuk tabel `dataDonasi`
--
ALTER TABLE `dataDonasi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
