CREATE TABLE `szamlak` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `szamlaszam` varchar(255) COLLATE utf8_hungarian_ci NOT NULL,
  `megjelenitnev` varchar(255) COLLATE utf8_hungarian_ci NOT NULL,
  `befizetesideje` varchar(45) COLLATE utf8_hungarian_ci NOT NULL,
  `prioritas` int(11) NOT NULL,
  `vartosszeg` int(11) NOT NULL,
  `szine` varchar(15) COLLATE utf8_hungarian_ci NOT NULL DEFAULT '0,255,0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;
