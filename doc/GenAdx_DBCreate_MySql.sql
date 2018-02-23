CREATE SCHEMA `genadx` DEFAULT CHARACTER SET latin1 ;

DROP TABLE IF EXISTS `genadx`.`consumer`;

CREATE TABLE `consumer` (
  `ConsumerID` int(11) NOT NULL AUTO_INCREMENT,
  `ConsumerFirstName` varchar(50) DEFAULT NULL,
  `ConsumerMiddleInitial` varchar(50) DEFAULT NULL,
  `ConsumerLastName` varchar(50) DEFAULT NULL,
  `ConsumerEmail` varchar(50) DEFAULT NULL,
  `ConsumerPhone` varchar(50) DEFAULT NULL,
  `ConsumerAddress` varchar(50) DEFAULT NULL,
  `ConsumerCity` varchar(50) DEFAULT NULL,
  `ConsumerState` varchar(50) DEFAULT NULL,
  `ConsumerZip` varchar(50) DEFAULT NULL,
  `ConsumerSocEmail` varchar(50) NOT NULL,
  `DemoID` int(11) DEFAULT NULL,
  `DeviceLocID`varchar(50) DEFAULT NULL,
  `ConsumerPWD`varchar(100) NOT NULL,
  `ProviderID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ConsumerID`),
  UNIQUE KEY `ConsumerSocEmail` (`ConsumerSocEmail`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `genadx`.`advertisement`;

CREATE TABLE `advertisement` (
  `IDentifier` int(11) NOT NULL AUTO_INCREMENT,
  `adID` int(11) NOT NULL,
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
  `adcampid` varchar(50) NOT NULL,
  PRIMARY KEY (`IDentifier`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `genadx`.`consumerHistory`;

CREATE TABLE `consumerhistory` (
  `consumerID` int(11) DEFAULT NULL,
  `preferenceID` int(11) DEFAULT NULL,
  `preferenceDate` varchar(50) NOT NULL,
  `preferenceChoice` int(11) DEFAULT NULL,
  `advertisementID` int(11) DEFAULT NULL,
  `couponID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `genadx`.`provider`;

CREATE TABLE `provider` (
  `IDentifier` int(11) NOT NULL AUTO_INCREMENT,
  `providerID` int(11) NOT NULL,
  `providerName` varchar(50) NOT NULL,
PRIMARY KEY (`IDentifier`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `genadx`.`coupon`;

CREATE TABLE `coupon` (
  `IDentifier` int(11) NOT NULL AUTO_INCREMENT,	 
  `couponID` int(11) DEFAULT NULL,
  `couponTitle` varchar(50) NOT NULL,
  `couponDescription` varchar(50) NOT NULL,
  `couponValue` varchar(50) NOT NULL,
  `couponStartActive` varchar(50) NOT NULL,
  `couponEndActive` varchar(50) NOT NULL,
  `couponLocationsZip` varchar(50) NOT NULL,
  `couponURL` varchar(50) NOT NULL,
  `adcampid` varchar(50) NOT NULL,
   `adID` int(11) NOT NULL,
  PRIMARY KEY (`IDentifier`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

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
  `preferenceID` int(11) NOT NULL AUTO_INCREMENT,
   `preferenceChoice` int(11) DEFAULT NULL,
  `preferenceDate` BIGINT NOT NULL,
  `advertisementID` int(11) DEFAULT NULL,
  `couponID` int(11) DEFAULT NULL,
  `consumerID` int(11) DEFAULT NULL,
  PRIMARY KEY (`preferenceID`),
  UNIQUE KEY `preferenceID` (`preferenceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `genadx`.`adimpression`;

CREATE TABLE `adimpression` (
`ImpID` int(11) NOT NULL AUTO_INCREMENT,
 `ConsumerID` int NOT NULL,
 `SessionID` int(11) NOT NULL,
  `ServiceID` int(11) NOT NULL,
  `ContentID` int(11) NOT NULL,
  `TerminalID` varchar(50) NOT NULL,
 `OppType` int(11) NOT NULL,
  `OppNum` int(11) NOT NULL,
 `OppDuration` int(11) NOT NULL,
 `AdPCC`varchar(50) NOT NULL,
  `AdCampID` varchar(50) NOT NULL,
 `AssetID` int(11) NOT NULL,
  `AssetProviderID` int(11) NOT NULL,
  `ViewStartTime` BIGINT NOT NULL,
  `ViewEndTime` BIGINT NOT NULL,
  `LocationID` int(11) NOT NULL,
  `LocationZip`varchar(50) NOT NULL,
PRIMARY KEY (`ImpID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `genadx`.`myads`;

CREATE TABLE `myads` (
  `IDentifier` int(11) NOT NULL AUTO_INCREMENT,
  `consumerID` int(11) NOT NULL,
  `adID` int(11) DEFAULT NULL,
  `adurl` varchar(50) NOT NULL,
  `adpcc` varchar(50) NOT NULL,
  `adtitle` varchar(50) NOT NULL,
  `addescription` varchar(50) NOT NULL,
  `adowner` varchar(50) NOT NULL,
  `couponID` int(11) DEFAULT NULL,
  `couponURL` varchar(50) NOT NULL,
  `couponTitle` varchar(50) NOT NULL,
  `couponDescription` varchar(50) NOT NULL,
  `couponValue` varchar(50) NOT NULL,
  `adcampid` varchar(50) NOT NULL,
    PRIMARY KEY (`IDentifier`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
 
 DROP TABLE IF EXISTS `genadx`.`interest`;

CREATE TABLE `interest` (
`IntID` int(11) NOT NULL AUTO_INCREMENT,
`IntDate` BIGINT NOT NULL,
`IntWeight` int NOT NULL, 
`ConsumerID` int NOT NULL,
`ProviderID` int NOT NULL,
`ProviderName` varchar(50) NOT NULL,
`LocationZip` varchar(50) NOT NULL,
`Demographic` int NOT NULL,
`AdID` int(11) DEFAULT NULL,
`AdURL` varchar(50) NOT NULL,
`AdPCC` varchar(50) NOT NULL,
`AdOwner` varchar(50) NOT NULL,
PRIMARY KEY (`IntID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
 
 DROP TABLE IF EXISTS `genadx`.`recommendation`;

CREATE TABLE `recommendation` (
`RecoID` int(11) NOT NULL AUTO_INCREMENT,
`RecoDate` DATETIME NOT NULL,
`RecoWeight` int NOT NULL, 
`ConsumerID` int NOT NULL,
`ProviderID` int NOT NULL,
`ProviderName` varchar(50) NOT NULL,
`LocationZip` varchar(50) NOT NULL,
`Demographic` int NOT NULL,
`AdID` int(11) DEFAULT NULL,
`AdURL` varchar(50) NOT NULL,
`AdPCC` varchar(50) NOT NULL,
`AdOwner` varchar(50) NOT NULL,
PRIMARY KEY (`RecoID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
 
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

DROP TABLE IF EXISTS `genadx`.`users`;

CREATE TABLE `genadx`.`users` (
  `username` varchar(50) NOT NULL ,
  `password` varchar(50) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO genadx.users (username,password,enabled) VALUES
("jason@jason.com", "{noop}test123",1);

INSERT INTO genadx.users (username,password,enabled) VALUES
("michael@jason.com", "{noop}test123",1);

DROP TABLE IF EXISTS `genadx`.`authorities`;

CREATE TABLE `genadx`.`authorities` (
  `username` varchar(50) NOT NULL ,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1`
  FOREIGN KEY (`username`)
  REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO genadx.authorities (username,authority) VALUES
("jason@jason.com", "ROLE_EMPLOYEE");

INSERT INTO genadx.authorities (username,authority) VALUES
("michael@jason.com", "ROLE_MANAGER");

INSERT INTO genadx.authorities (username,authority) VALUES
("jason@jason.com", "ROLE_ADMIN");

INSERT INTO genadx.authorities (username,authority) VALUES
("michael@jason.com", "ROLE_EMPLOYEE");







