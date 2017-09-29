DROP TABLE IF EXISTS `genadx`.`consumer`;

CREATE TABLE `consumer` (
  `ConsumerID` int(11) NOT NULL AUTO_INCREMENT,
  `ConsumerFirstName` varchar(50) NOT NULL,
  `ConsumerMiddleInitial` varchar(50) DEFAULT NULL,
  `ConsumerLastName` varchar(50) NOT NULL,
  `ConsumerEmail` varchar(50) NOT NULL,
  `ConsumerPhone` varchar(50) DEFAULT NULL,
  `ConsumerAddress` varchar(50) NOT NULL,
  `ConsumerCity` varchar(50) NOT NULL,
  `ConsumerState` varchar(50) NOT NULL,
  `ConsumerZip` varchar(50) NOT NULL,
  `ConsumerSocEmail` varchar(50) NOT NULL,
  PRIMARY KEY (`ConsumerID`),
  UNIQUE KEY `ConsumerSocEmail` (`ConsumerSocEmail`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `genadx`.`advertisement`;

CREATE TABLE `advertisement` (
  `adID` int(11) DEFAULT NULL,
  `adtitle` varchar(50) NOT NULL,
  `addemo01` int(11) DEFAULT NULL,
  `addemo02` int(11) DEFAULT NULL,
  `addemo03` int(11) DEFAULT NULL,
  `addemo04` int(11) DEFAULT NULL,
  `addescription` varchar(50) NOT NULL,
  `adowner` varchar(50) NOT NULL,
  `adbrand` varchar(50) NOT NULL,
  `adpcc` varchar(50) NOT NULL,
  `adurl` varchar(50) NOT NULL,
  `adcampid` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `genadx`.`consumerHistory`;

CREATE TABLE `consumerhistory` (
  `consumerID` int(11) DEFAULT NULL,
  `preferenceID` int(11) DEFAULT NULL,
  `preferenceDate` varchar(50) NOT NULL,
  `preferenceChoice` int(11) DEFAULT NULL,
  `advertisementID` int(11) DEFAULT NULL,
  `couponID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `genadx`.`coupon`;

CREATE TABLE `coupon` (
  `couponID` int(11) DEFAULT NULL,
  `couponTitle` varchar(50) NOT NULL,
  `couponDescription` varchar(50) NOT NULL,
  `couponValue` float DEFAULT NULL,
  `couponStartActive` varchar(50) NOT NULL,
  `couponEndActive` varchar(50) NOT NULL,
  `couponLocationsZip` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `genadx`.`log`;

CREATE TABLE `log` (
  `Id` int(11) NOT NULL,
  `Date` datetime NOT NULL,
  `Thread` varchar(255) NOT NULL,
  `Level` varchar(50) NOT NULL,
  `Logger` varchar(255) NOT NULL,
  `Message` varchar(4000) NOT NULL,
  `Exception` varchar(2000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `genadx`.`preference`;

CREATE TABLE `preference` (
  `preferenceID` int(11) DEFAULT NULL,
  `preferenceGsSegment` int(11) DEFAULT NULL,
  `preferenceCaTypeCode` int(11) DEFAULT NULL,
  `preferenceCaValueCode` int(11) DEFAULT NULL,
  `preferencePcc` int(11) DEFAULT NULL,
  `preferenceBrandOwner` varchar(50) DEFAULT NULL,
  `preferenceProductDesc` varchar(50) DEFAULT NULL,
  `preferenceDate` varchar(50) DEFAULT NULL,
  `consumerID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `genadx`.`adimpression`;

CREATE TABLE `adimpression` (
 `ConsumerID` int NOT NULL,
 `SessionID` varchar(50) NOT NULL,
  `ServiceID` varchar(50) NOT NULL,
  `ContentID` varchar(50) NOT NULL,
  `Duration` varchar(50) NOT NULL,
  `CurrentDateTime` varchar(50) NOT NULL,
  `TerminalID` varchar(50) NOT NULL,
 `OppType` varchar(50) NOT NULL,
  `OppNum` varchar(50) NOT NULL,
 `OppDuration` varchar(50) NOT NULL,
 `PCCCode` varchar(50) NOT NULL,
  `AdCampID` varchar(50) NOT NULL,
 `AssetID` varchar(50) NOT NULL,
  `AssetProviderID` varchar(50) NOT NULL,
  `ViewStartTime` varchar(50) NOT NULL,
  `ViewEndTime` varchar(50) NOT NULL,
  `LocationID` varchar(50) NOT NULL,
  `LocationZip` varchar(50) NOT NULL,
  PRIMARY KEY (`ConsumerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `genadx`.`login`;

CREATE TABLE `genadx`.`login` (
  `UserName` varchar(100) NOT NULL ,
  `PassWord` varchar(100) NOT NULL,
  PRIMARY KEY (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO genadx.login (UserName,PassWord) VALUES
("Jason", "Canney");

INSERT INTO genadx.login (UserName,PassWord) VALUES
("admin", "admin");
