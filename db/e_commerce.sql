-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Ott 07, 2021 alle 10:11
-- Versione del server: 10.4.20-MariaDB
-- Versione PHP: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `e_commerce`
--
CREATE DATABASE IF NOT EXISTS `e_commerce` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `e_commerce`;

-- --------------------------------------------------------

--
-- Struttura della tabella `anagrafica_clienti`
--

CREATE TABLE `anagrafica_clienti` (
  `id_anagrafica_clienti` int(11) NOT NULL,
  `nominativo` varchar(50) DEFAULT NULL,
  `indirizzo` varchar(100) DEFAULT NULL,
  `localita` varchar(50) DEFAULT NULL,
  `cap` varchar(5) DEFAULT NULL,
  `provincia` varchar(2) DEFAULT NULL,
  `codice_fiscale` varchar(20) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `username_cliente` varchar(20) DEFAULT NULL,
  `password_cliente` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `anagrafica_clienti`
--

INSERT INTO `anagrafica_clienti` (`id_anagrafica_clienti`, `nominativo`, `indirizzo`, `localita`, `cap`, `provincia`, `codice_fiscale`, `email`, `username_cliente`, `password_cliente`) VALUES
(1, 'Luca Marolla', 'Via Fieramosca,12', 'Bisceglie', '76011', 'BT', 'TBGFQL48E70B173X', 'luca.m@libero.it', 'LucaMarollas10', 'ABBA12'),
(2, 'Simone Campochiaro', 'Via Millico,56', 'Terlizzi', '70038', 'BA', 'NBGTNZ80R31F373A', 'sim.camp97@hotmail.it', 'sim.97.camp', 'terlizzi'),
(3, 'Cristian Iacovelli', 'Via Metastasio, 18', 'Bari', '70121', 'BA', 'HFVNHV70D18F720W', 'Cri_Iacov1234@gmail.com', 'Cri_Iacov1234', 'bari56'),
(4, 'Umberto Tangari', 'Contrada Pozzo Lungo, 23', 'Terlizzi', '70038', 'BA', 'MRJSQP51A05E314O', 'umb.terl@libero.com', 'umb94T', 'aria12'),
(5, 'Nicola Narducci', 'Via Picasso, 110', 'Foggia', '7110', 'FG', 'CYGRDD99S14B557D', 'nardinoNic@libero.com', 'Nico_ultras', 'foggia1');

-- --------------------------------------------------------

--
-- Struttura della tabella `anagrafica_fornitori`
--

CREATE TABLE `anagrafica_fornitori` (
  `id_anagrafica_fornitori` int(11) NOT NULL,
  `nominativo` varchar(50) DEFAULT NULL,
  `indirizzo` varchar(100) DEFAULT NULL,
  `localita` varchar(50) DEFAULT NULL,
  `cap` varchar(5) DEFAULT NULL,
  `provincia` varchar(2) DEFAULT NULL,
  `partita_iva` varchar(20) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `sito_web` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `anagrafica_fornitori`
--

INSERT INTO `anagrafica_fornitori` (`id_anagrafica_fornitori`, `nominativo`, `indirizzo`, `localita`, `cap`, `provincia`, `partita_iva`, `email`, `sito_web`) VALUES
(1, 'Cellulopoli Sas', 'Via duca degli Abruzzi, 98', 'Molfetta', '70056', 'BA', '1201CYGRDD99S14B557D', 'cullulopolisas@gmail.com', 'www.cellulopolisas.it'),
(2, 'Hardware per Tutti SRL', 'Via Canonico, 12', 'Ruvo di Puglia', '70039', 'BA', '90ASGRDD99S14B334D', 'hdpertutti@live.it', 'www.hdpertutti.it');

-- --------------------------------------------------------

--
-- Struttura della tabella `assemblati`
--

CREATE TABLE `assemblati` (
  `id_assemblato` int(11) NOT NULL,
  `nome_assemblato` varchar(50) DEFAULT NULL,
  `descrizione` varchar(100) NOT NULL,
  `prezzo_di_vendita` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `assemblati`
--

INSERT INTO `assemblati` (`id_assemblato`, `nome_assemblato`, `descrizione`, `prezzo_di_vendita`) VALUES
(5, 'PC Assemblato Pincopallo', 'Descrizione pc', 600);

-- --------------------------------------------------------

--
-- Struttura della tabella `carrello`
--

CREATE TABLE `carrello` (
  `id_carrello` int(11) NOT NULL,
  `data_carrello` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `carrello`
--

INSERT INTO `carrello` (`id_carrello`, `data_carrello`) VALUES
(1, '2021-10-06'),
(2, '2021-10-06');

-- --------------------------------------------------------

--
-- Struttura della tabella `ordini`
--

CREATE TABLE `ordini` (
  `id_ordine` int(11) NOT NULL,
  `id_carrello` int(11) DEFAULT NULL,
  `id_anagrafica_cliente` int(11) DEFAULT NULL,
  `importo` double DEFAULT NULL,
  `data_consegna` date DEFAULT NULL,
  `ora_consegna` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `ordini`
--

INSERT INTO `ordini` (`id_ordine`, `id_carrello`, `id_anagrafica_cliente`, `importo`, `data_consegna`, `ora_consegna`) VALUES
(1, 2, 1, 340, '2021-10-07', '15:13:49');

-- --------------------------------------------------------

--
-- Struttura della tabella `prodotti`
--

CREATE TABLE `prodotti` (
  `id_prodotto` int(11) NOT NULL,
  `componente` varchar(50) DEFAULT NULL,
  `descrizione` text DEFAULT NULL,
  `codice_ian13` varchar(12) DEFAULT NULL,
  `quantita` int(11) NOT NULL,
  `disponibilita` tinyint(1) DEFAULT NULL,
  `prezzo_di_acquisto` double DEFAULT NULL,
  `prezzo_di_vendita` double DEFAULT NULL,
  `id_anagrafica_fornitore` int(11) DEFAULT NULL,
  `id_assemblato` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `prodotti`
--

INSERT INTO `prodotti` (`id_prodotto`, `componente`, `descrizione`, `codice_ian13`, `quantita`, `disponibilita`, `prezzo_di_acquisto`, `prezzo_di_vendita`, `id_anagrafica_fornitore`, `id_assemblato`) VALUES
(1, 'AMD Ryzen™ 7 5700G Processore', 'AMD Ryzen™ 7 5700G Processor\r\nGraphics Model: Integrated Radeon Graphics\r\n# of CPU Cores: 8\r\n# of Threads: 16\r\nMax Boost Clock: Up to 4.6GHz\r\nBase Clock: 3.8GHz\r\nThermal Solution: Wraith Stealth\r\nDefault TDP / TDP: 65W', '1', 0, 1, 322.49, 379.49, NULL, NULL),
(2, 'RAM Samsung', 'BL2K8G32C16U4B 3200 MHz, DDR4, DRAM, Memoria Gaming Kit per Computer Fissi, 16GB (8GB x2), CL16, Nero', '10', 0, 0, 70, 85, 1, NULL),
(3, 'Scheda Video GeForce', '2 GB GDDR3, PCI Express 2.0, HDMI + DL-DVI-D, Nero', '102', 0, 0, 100, 125, 2, NULL),
(4, 'Pc Pincopallo', 'Pc assemblato', '123456789123', 0, NULL, NULL, 600, NULL, 5);

-- --------------------------------------------------------

--
-- Struttura della tabella `prodotti_assemblato`
--

CREATE TABLE `prodotti_assemblato` (
  `id_componenti_assemblato` int(11) NOT NULL,
  `id_assemblato` int(11) DEFAULT NULL,
  `id_prodotto` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `prodotti_assemblato`
--

INSERT INTO `prodotti_assemblato` (`id_componenti_assemblato`, `id_assemblato`, `id_prodotto`) VALUES
(3, 5, 1),
(4, 5, 2),
(5, 5, 3);

-- --------------------------------------------------------

--
-- Struttura della tabella `prodotti_nel_carrello`
--

CREATE TABLE `prodotti_nel_carrello` (
  `id_prodotto_nel_carrello` int(11) NOT NULL,
  `data_prodotto_carrello` timestamp NULL DEFAULT NULL,
  `id_prodotto` int(11) DEFAULT NULL,
  `prezzo_di_vendita` double DEFAULT NULL,
  `sconto` double DEFAULT NULL COMMENT 'coupon',
  `codice_coupon` varchar(11) NOT NULL,
  `id_carrello` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `prodotti_nel_carrello`
--

INSERT INTO `prodotti_nel_carrello` (`id_prodotto_nel_carrello`, `data_prodotto_carrello`, `id_prodotto`, `prezzo_di_vendita`, `sconto`, `codice_coupon`, `id_carrello`) VALUES
(1, '2021-10-05 22:00:00', 1, NULL, NULL, '0', NULL),
(2, NULL, 1, 340, NULL, '123', 2),
(3, NULL, 4, 2311, NULL, '456', 2);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `anagrafica_clienti`
--
ALTER TABLE `anagrafica_clienti`
  ADD PRIMARY KEY (`id_anagrafica_clienti`);

--
-- Indici per le tabelle `anagrafica_fornitori`
--
ALTER TABLE `anagrafica_fornitori`
  ADD PRIMARY KEY (`id_anagrafica_fornitori`);

--
-- Indici per le tabelle `assemblati`
--
ALTER TABLE `assemblati`
  ADD PRIMARY KEY (`id_assemblato`);

--
-- Indici per le tabelle `carrello`
--
ALTER TABLE `carrello`
  ADD PRIMARY KEY (`id_carrello`);

--
-- Indici per le tabelle `ordini`
--
ALTER TABLE `ordini`
  ADD PRIMARY KEY (`id_ordine`),
  ADD KEY `id_anagrafica_clienti` (`id_anagrafica_cliente`),
  ADD KEY `id_carrello` (`id_carrello`);

--
-- Indici per le tabelle `prodotti`
--
ALTER TABLE `prodotti`
  ADD PRIMARY KEY (`id_prodotto`),
  ADD KEY `id_anagrafica_fornitore` (`id_anagrafica_fornitore`),
  ADD KEY `id_assemblato` (`id_assemblato`);

--
-- Indici per le tabelle `prodotti_assemblato`
--
ALTER TABLE `prodotti_assemblato`
  ADD PRIMARY KEY (`id_componenti_assemblato`),
  ADD KEY `id_assemblato` (`id_assemblato`),
  ADD KEY `id_componente` (`id_prodotto`);

--
-- Indici per le tabelle `prodotti_nel_carrello`
--
ALTER TABLE `prodotti_nel_carrello`
  ADD PRIMARY KEY (`id_prodotto_nel_carrello`),
  ADD KEY `id_componente` (`id_prodotto`),
  ADD KEY `id_carrello` (`id_carrello`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `anagrafica_clienti`
--
ALTER TABLE `anagrafica_clienti`
  MODIFY `id_anagrafica_clienti` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `anagrafica_fornitori`
--
ALTER TABLE `anagrafica_fornitori`
  MODIFY `id_anagrafica_fornitori` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `assemblati`
--
ALTER TABLE `assemblati`
  MODIFY `id_assemblato` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `carrello`
--
ALTER TABLE `carrello`
  MODIFY `id_carrello` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `ordini`
--
ALTER TABLE `ordini`
  MODIFY `id_ordine` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `prodotti`
--
ALTER TABLE `prodotti`
  MODIFY `id_prodotto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `prodotti_assemblato`
--
ALTER TABLE `prodotti_assemblato`
  MODIFY `id_componenti_assemblato` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `prodotti_nel_carrello`
--
ALTER TABLE `prodotti_nel_carrello`
  MODIFY `id_prodotto_nel_carrello` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `ordini`
--
ALTER TABLE `ordini`
  ADD CONSTRAINT `id_anagrafica_clienti` FOREIGN KEY (`id_anagrafica_cliente`) REFERENCES `anagrafica_clienti` (`id_anagrafica_clienti`),
  ADD CONSTRAINT `ordini_ibfk_1` FOREIGN KEY (`id_carrello`) REFERENCES `carrello` (`id_carrello`);

--
-- Limiti per la tabella `prodotti`
--
ALTER TABLE `prodotti`
  ADD CONSTRAINT `prodotti_ibfk_1` FOREIGN KEY (`id_anagrafica_fornitore`) REFERENCES `anagrafica_fornitori` (`id_anagrafica_fornitori`),
  ADD CONSTRAINT `prodotti_ibfk_2` FOREIGN KEY (`id_assemblato`) REFERENCES `assemblati` (`id_assemblato`);

--
-- Limiti per la tabella `prodotti_assemblato`
--
ALTER TABLE `prodotti_assemblato`
  ADD CONSTRAINT `prodotti_assemblato_ibfk_1` FOREIGN KEY (`id_prodotto`) REFERENCES `prodotti` (`id_prodotto`),
  ADD CONSTRAINT `prodotti_assemblato_ibfk_2` FOREIGN KEY (`id_assemblato`) REFERENCES `assemblati` (`id_assemblato`);

--
-- Limiti per la tabella `prodotti_nel_carrello`
--
ALTER TABLE `prodotti_nel_carrello`
  ADD CONSTRAINT `id_carrello` FOREIGN KEY (`id_carrello`) REFERENCES `carrello` (`id_carrello`),
  ADD CONSTRAINT `id_prodotto` FOREIGN KEY (`id_prodotto`) REFERENCES `prodotti` (`id_prodotto`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
