-- phpMyAdmin SQL Dump
-- version 5.3.0-dev+20220604.11e8242d04
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-07-2022 a las 02:23:57
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cinemar`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `butaca`
--

CREATE TABLE `butaca` (
  `id` int(11) NOT NULL,
  `fila` varchar(2) NOT NULL,
  `reservada` tinyint(1) DEFAULT 0,
  `numeracion` tinyint(4) NOT NULL,
  `id_sala` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `butaca`
--

INSERT INTO `butaca` (`id`, `fila`, `reservada`, `numeracion`, `id_sala`) VALUES
(1, 'A', 1, 2, 1),
(2, 'B', 0, 3, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clasificacion`
--

CREATE TABLE `clasificacion` (
  `id` int(11) NOT NULL,
  `identificador` varchar(4) NOT NULL,
  `recomendacion` varchar(30) NOT NULL,
  `descripcion` varchar(2024) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clasificacion`
--

INSERT INTO `clasificacion` (`id`, `identificador`, `recomendacion`, `descripcion`) VALUES
(1, 'ATP', 'Todas las Edades', 'Todas las edades pueden ver. No hay desnudez ni sangre y/o alcohol. El lenguaje es cortés sin el uso de insultos o con ofensas muy suaves que caen en lo gracioso.'),
(2, '+13', 'Apta para mayores de 13 años', 'Desnudez parcial, sangre leve, muertes poco violentas, lenguaje regularizado e imágenes intensas suelen aparecer en las películas de esta clasificación. Pueden ingresar menores si van acompañados por un familiar o tutor.'),
(3, '+16', 'Apta para mayores de 13 años', 'Desnudez fuerte y explícita —pero no pornográfica—, escenas fuertes, alcohol y drogas, insultos, imágenes muy intensas, muertes muy violentas y sangre en mucha cantidad —gore—. Se recomienda discreción para los menores de 16 años.'),
(4, '+18', 'Apta para mayores de 18 años.', 'Los menores de edad no están destinados a ver la película. Desnudez fuerte —pornografía—, violencia extrema, muertes extremadamente violentas, lenguaje ofensivo, derramamiento de sangre —gore extremo—, imágenes intensas frecuentes, escenas intensamente fuertes, insultos intensos y alcohol, drogas y tabaco.'),
(5, 'C', 'Exhibición condicionada.', 'Adecuado para mayores de 18 años. Restringido a lugares especialmente autorizados. Los menores de edad no están destinados a ver la película. Los mayores de edad tampoco están destinados a ver esto en cines autorizados.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `descuento`
--

CREATE TABLE `descuento` (
  `id` int(11) NOT NULL,
  `porcentaje` float NOT NULL,
  `dia` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `descuento`
--

INSERT INTO `descuento` (`id`, `porcentaje`, `dia`) VALUES
(1, 10, 'Domingo'),
(2, 20, 'Lunes'),
(3, 15, 'Martes'),
(4, 20, 'Miercoles'),
(5, 15, 'Jueves'),
(6, 10, 'Viernes'),
(7, 10, 'Sabado'),
(8, 0, 'Sin Descue');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `formato`
--

CREATE TABLE `formato` (
  `id` int(11) NOT NULL,
  `tipo` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `formato`
--

INSERT INTO `formato` (`id`, `tipo`) VALUES
(1, '2d'),
(2, '3d'),
(3, '4d');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genero`
--

CREATE TABLE `genero` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `genero`
--

INSERT INTO `genero` (`id`, `nombre`) VALUES
(1, 'Acción'),
(2, 'Aventuras'),
(3, 'Ciencia Ficción'),
(4, 'Comedia'),
(5, 'No- Ficción / documental.'),
(6, 'Drama'),
(7, 'Fantasía'),
(8, 'Musical');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelicula`
--

CREATE TABLE `pelicula` (
  `id_pelicula` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `duracion` int(11) NOT NULL,
  `id_tipoPelicula` int(11) NOT NULL,
  `id_clasificacion` int(11) NOT NULL,
  `sinopsis` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pelicula`
--

INSERT INTO `pelicula` (`id_pelicula`, `nombre`, `duracion`, `id_tipoPelicula`, `id_clasificacion`, `sinopsis`) VALUES
(1, 'Rey Leon', 123, 1, 1, 'Tras la muerte de su padre, Simba deberá enfrentarse a su tío para recuperar el trono de Rey de la Selva. Timón y Pumba le acompañarán en su misión.'),
(2, 'Harry Potter', 200, 1, 1, 'El día de su cumpleaños, Harry Potter descubre que es hijo de dos conocidos hechiceros, de los que ha heredado poderes mágicos. Debe asistir a una famosa escuela de magia y hechicería, donde entabla una amistad con dos jóvenes que se convertirán en sus compañeros de aventura. Durante su primer año en Hogwarts, descubre que un malévolo y poderoso mago llamado Voldemort está en busca de una piedra filosofal que alarga la vida de quien la posee.'),
(3, 'Lightyear', 123, 2, 1, 'Buzz Lightyear se embarca en una aventura intergaláctica con un grupo de reclutas ambiciosos y su compañero robot. Los amigos tendrán que aprender a trabajar juntos para escapar del malvado Zurg y su ejército de robots.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `peliculaxgenero`
--

CREATE TABLE `peliculaxgenero` (
  `id` int(11) NOT NULL,
  `id_pelicula` int(11) NOT NULL,
  `id_genero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `peliculaxreparto`
--

CREATE TABLE `peliculaxreparto` (
  `id` int(11) NOT NULL,
  `id_pelicula` int(11) NOT NULL,
  `id_reparto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reparto`
--

CREATE TABLE `reparto` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `id` int(11) NOT NULL,
  `precio` float NOT NULL,
  `fecha_compra` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `id_sesion` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_butaca` int(11) NOT NULL,
  `id_descuento` int(11) DEFAULT NULL,
  `nro_tarjetaCredito` bigint(20) NOT NULL,
  `total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`id`, `precio`, `fecha_compra`, `id_sesion`, `id_usuario`, `id_butaca`, `id_descuento`, `nro_tarjetaCredito`, `total`) VALUES
(9, 500, '2022-07-10 04:30:06', 8, 1, 2, 1, 1234423, 475),
(10, 400, '2022-07-10 01:29:00', 5, 1, 1, 1, 1234423, 323),
(11, 8000, '2022-07-10 04:21:23', 6, 1, 2, 1, 1234423, 231),
(12, 500, '2022-07-10 01:31:31', 5, 1, 1, 1, 1234423, 450),
(14, 3000, '2022-07-10 23:18:02', 5, 2, 2, 8, 45764234, 3000),
(15, 3000, '2022-07-10 23:19:30', 5, 2, 2, 1, 45764234, 2100),
(16, 50, '2022-07-10 23:39:52', 5, 3, 2, 8, 45764234, 50),
(17, 150, '2022-07-11 00:19:03', 5, 3, 2, 8, 45764234, 150);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sala`
--

CREATE TABLE `sala` (
  `id` int(11) NOT NULL,
  `numero` int(11) DEFAULT NULL,
  `capacidad` int(11) DEFAULT NULL,
  `id_formato` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `sala`
--

INSERT INTO `sala` (`id`, `numero`, `capacidad`, `id_formato`) VALUES
(1, 1, 50, 1),
(2, 2, 100, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sesion`
--

CREATE TABLE `sesion` (
  `id` int(11) NOT NULL,
  `fechaYhora` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `id_sala` int(11) NOT NULL,
  `id_pelicula` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `sesion`
--

INSERT INTO `sesion` (`id`, `fechaYhora`, `id_sala`, `id_pelicula`) VALUES
(1, '2022-07-03 03:00:00', 2, 2),
(2, '2022-07-03 03:00:00', 1, 1),
(3, '2022-07-04 03:00:00', 1, 1),
(4, '2022-10-10 03:00:00', 1, 1),
(5, '2022-07-14 03:00:00', 1, 1),
(6, '2022-07-08 03:00:00', 1, 1),
(7, '2022-12-11 01:10:00', 2, 2),
(8, '2022-10-07 16:30:00', 2, 1),
(9, '2022-10-15 16:30:00', 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarjetacredito`
--

CREATE TABLE `tarjetacredito` (
  `numero` bigint(20) NOT NULL,
  `banco` varchar(20) NOT NULL,
  `titular` varchar(60) NOT NULL,
  `fecha_caducidad` date NOT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tarjetacredito`
--

INSERT INTO `tarjetacredito` (`numero`, `banco`, `titular`, `fecha_caducidad`, `id_usuario`) VALUES
(1234423, 'Santander', 'Mamani Mauricio', '2022-02-10', 1),
(45764234, 'HBC', 'Santiago Torres', '2025-03-10', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_pelicula`
--

CREATE TABLE `tipo_pelicula` (
  `id` int(11) NOT NULL,
  `id_formato` int(11) NOT NULL,
  `idioma` varchar(12) NOT NULL,
  `subtitulada` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_pelicula`
--

INSERT INTO `tipo_pelicula` (`id`, `id_formato`, `idioma`, `subtitulada`) VALUES
(1, 1, 'Castellano', 0),
(2, 1, 'Latino', 0),
(3, 1, 'Ingles', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `documento` varchar(10) NOT NULL,
  `fecha_nac` date DEFAULT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `correo` varchar(30) DEFAULT NULL,
  `numeroContacto` varchar(13) DEFAULT NULL,
  `nombreDeUsuario` varchar(20) NOT NULL,
  `contraseña` varchar(30) DEFAULT NULL,
  `tieneDescuento` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `documento`, `fecha_nac`, `nombre`, `apellido`, `correo`, `numeroContacto`, `nombreDeUsuario`, `contraseña`, `tieneDescuento`) VALUES
(1, 'null', '2000-05-23', 'Mauricio', 'Mamani', 'maurobvx@gmail.com', 'null', 'ichexpa', '123456788', 1),
(2, '22133455', '2000-02-10', 'Pedro', 'Torres', 'pedroT@gmail.com', 'null', 'pedroT', 'pedroT123', 1),
(3, '99233455', '2000-02-10', 'Agustin', 'Torres', 'ags@gmail.com', 'null', 'aguTo', '122223453', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `butaca`
--
ALTER TABLE `butaca`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_sala` (`id_sala`);

--
-- Indices de la tabla `clasificacion`
--
ALTER TABLE `clasificacion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `descuento`
--
ALTER TABLE `descuento`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `formato`
--
ALTER TABLE `formato`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD PRIMARY KEY (`id_pelicula`),
  ADD KEY `fk_clasificacion` (`id_clasificacion`),
  ADD KEY `fk_tipoPelicula` (`id_tipoPelicula`);

--
-- Indices de la tabla `peliculaxgenero`
--
ALTER TABLE `peliculaxgenero`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_genero` (`id_genero`),
  ADD KEY `fk_pelicula` (`id_pelicula`);

--
-- Indices de la tabla `peliculaxreparto`
--
ALTER TABLE `peliculaxreparto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_pelicula` (`id_pelicula`),
  ADD KEY `id_reparto` (`id_reparto`);

--
-- Indices de la tabla `reparto`
--
ALTER TABLE `reparto`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_sesion` (`id_sesion`),
  ADD KEY `fk_usuario` (`id_usuario`),
  ADD KEY `fk_butaca` (`id_butaca`),
  ADD KEY `fk_tarjetaCredito` (`nro_tarjetaCredito`),
  ADD KEY `fk_descuento` (`id_descuento`);

--
-- Indices de la tabla `sala`
--
ALTER TABLE `sala`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_formato` (`id_formato`);

--
-- Indices de la tabla `sesion`
--
ALTER TABLE `sesion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_sala_S` (`id_sala`),
  ADD KEY `fk_pelicula_S` (`id_pelicula`);

--
-- Indices de la tabla `tarjetacredito`
--
ALTER TABLE `tarjetacredito`
  ADD PRIMARY KEY (`numero`),
  ADD KEY `fk_usuarioT` (`id_usuario`);

--
-- Indices de la tabla `tipo_pelicula`
--
ALTER TABLE `tipo_pelicula`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_formato1` (`id_formato`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `butaca`
--
ALTER TABLE `butaca`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `clasificacion`
--
ALTER TABLE `clasificacion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `descuento`
--
ALTER TABLE `descuento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `formato`
--
ALTER TABLE `formato`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `genero`
--
ALTER TABLE `genero`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  MODIFY `id_pelicula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `peliculaxgenero`
--
ALTER TABLE `peliculaxgenero`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `peliculaxreparto`
--
ALTER TABLE `peliculaxreparto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `reparto`
--
ALTER TABLE `reparto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `sala`
--
ALTER TABLE `sala`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `sesion`
--
ALTER TABLE `sesion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `tipo_pelicula`
--
ALTER TABLE `tipo_pelicula`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `butaca`
--
ALTER TABLE `butaca`
  ADD CONSTRAINT `fk_sala` FOREIGN KEY (`id_sala`) REFERENCES `sala` (`id`);

--
-- Filtros para la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD CONSTRAINT `fk_clasificacion` FOREIGN KEY (`id_clasificacion`) REFERENCES `clasificacion` (`id`),
  ADD CONSTRAINT `fk_tipoPelicula` FOREIGN KEY (`id_tipoPelicula`) REFERENCES `tipo_pelicula` (`id`);

--
-- Filtros para la tabla `peliculaxgenero`
--
ALTER TABLE `peliculaxgenero`
  ADD CONSTRAINT `fk_genero` FOREIGN KEY (`id_genero`) REFERENCES `genero` (`id`),
  ADD CONSTRAINT `fk_pelicula` FOREIGN KEY (`id_pelicula`) REFERENCES `pelicula` (`id_pelicula`);

--
-- Filtros para la tabla `peliculaxreparto`
--
ALTER TABLE `peliculaxreparto`
  ADD CONSTRAINT `peliculaxreparto_ibfk_1` FOREIGN KEY (`id_pelicula`) REFERENCES `pelicula` (`id_pelicula`),
  ADD CONSTRAINT `peliculaxreparto_ibfk_2` FOREIGN KEY (`id_reparto`) REFERENCES `reparto` (`id`);

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `fk_butaca` FOREIGN KEY (`id_butaca`) REFERENCES `butaca` (`id`),
  ADD CONSTRAINT `fk_descuento` FOREIGN KEY (`id_descuento`) REFERENCES `descuento` (`id`),
  ADD CONSTRAINT `fk_sesion` FOREIGN KEY (`id_sesion`) REFERENCES `sesion` (`id`),
  ADD CONSTRAINT `fk_tarjetaCredito` FOREIGN KEY (`nro_tarjetaCredito`) REFERENCES `tarjetacredito` (`numero`),
  ADD CONSTRAINT `fk_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `sala`
--
ALTER TABLE `sala`
  ADD CONSTRAINT `fk_formato` FOREIGN KEY (`id_formato`) REFERENCES `formato` (`id`);

--
-- Filtros para la tabla `sesion`
--
ALTER TABLE `sesion`
  ADD CONSTRAINT `fk_pelicula_S` FOREIGN KEY (`id_pelicula`) REFERENCES `pelicula` (`id_pelicula`),
  ADD CONSTRAINT `fk_sala_S` FOREIGN KEY (`id_sala`) REFERENCES `sala` (`id`);

--
-- Filtros para la tabla `tarjetacredito`
--
ALTER TABLE `tarjetacredito`
  ADD CONSTRAINT `fk_usuarioT` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `tipo_pelicula`
--
ALTER TABLE `tipo_pelicula`
  ADD CONSTRAINT `fk_formato1` FOREIGN KEY (`id_formato`) REFERENCES `formato` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;



