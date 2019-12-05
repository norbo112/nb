-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2019. Dec 05. 20:02
-- Kiszolgáló verziója: 10.1.32-MariaDB
-- PHP verzió: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `csaladikassza`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `szamlak`
--

CREATE TABLE `szamlak` (
  `id` int(11) NOT NULL,
  `szamlaszam` varchar(255) COLLATE utf8_hungarian_ci NOT NULL,
  `megjelenitnev` varchar(255) COLLATE utf8_hungarian_ci NOT NULL,
  `befizetesideje` varchar(45) COLLATE utf8_hungarian_ci NOT NULL,
  `prioritas` int(11) NOT NULL,
  `vartosszeg` int(11) NOT NULL,
  `szine` varchar(15) COLLATE utf8_hungarian_ci NOT NULL DEFAULT '0,255,0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `szamlak`
--

INSERT INTO `szamlak` (`id`, `szamlaszam`, `megjelenitnev`, `befizetesideje`, `prioritas`, `vartosszeg`, `szine`) VALUES
(1, '2255--554433-3344', 'GázHivatal', '2019-08-10', 3, 12500, '0,255,255'),
(2, '113-225-43-554', 'Vizhivatal', '2019-11-21', 1, 25000, '255,255,0'),
(3, '458-885-88', 'V-Hivatal', '1995-05-12', 1, 12500, '0,255,125'),
(4, '557788', 'FűtésHív', '2019-09-14', 2, 45000, '125,255,0');

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `szamlak`
--
ALTER TABLE `szamlak`
  ADD PRIMARY KEY (`id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `szamlak`
--
ALTER TABLE `szamlak`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
