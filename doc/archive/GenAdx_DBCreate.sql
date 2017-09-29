USE genadx;

/* DROP TABLE IF EXISTS [genadx`.`consumer];
*/
CREATE TABLE consumer (
  [ConsumerID] int NOT NULL IDENTITY,
  [ConsumerFirstName] varchar(50) NOT NULL,
  [ConsumerMiddleInitial] varchar(50) DEFAULT NULL,
  [ConsumerLastName] varchar(50) NOT NULL,
  [ConsumerEmail] varchar(50) NOT NULL,
  [ConsumerPhone] varchar(50) DEFAULT NULL,
  [ConsumerAddress] varchar(50) NOT NULL,
  [ConsumerCity] varchar(50) NOT NULL,
  [ConsumerState] varchar(50) NOT NULL,
  [ConsumerZip] varchar(50) NOT NULL,
  [ConsumerSocEmail] varchar(50) NOT NULL,
  PRIMARY KEY ([ConsumerID]),
  CONSTRAINT [ConsumerSocEmail] UNIQUE  ([ConsumerSocEmail])
)  ;
/*
DROP TABLE IF EXISTS [genadx`.`advertisement];
*/
CREATE TABLE advertisement (
  [adID] int DEFAULT NULL,
  [adtitle] varchar(50) NOT NULL,
  [addemo01] int DEFAULT NULL,
  [addemo02] int DEFAULT NULL,
  [addemo03] int DEFAULT NULL,
  [addemo04] int DEFAULT NULL,
  [addescription] varchar(50) NOT NULL,
  [adowner] varchar(50) NOT NULL,
  [adbrand] varchar(50) NOT NULL,
  [adPCC] varchar(50) NOT NULL,
  [adURL] varchar(50) NOT NULL,
  [adCampID] varchar(50) DEFAULT NULL
) ;
/*
DROP TABLE IF EXISTS [genadx`.`consumerHistory];
*/
CREATE TABLE consumerhistory (
  [consumerID] int DEFAULT NULL,
  [preferenceID] int DEFAULT NULL,
  [preferenceDate] varchar(50) NOT NULL,
  [preferenceChoice] int DEFAULT NULL,
  [advertisementID] int DEFAULT NULL,
  [couponID] int DEFAULT NULL
) ;
/*
DROP TABLE IF EXISTS [genadx`.`coupon];
*/
CREATE TABLE coupon (
  [couponID] int DEFAULT NULL,
  [couponTitle] varchar(50) NOT NULL,
  [couponDescription] varchar(50) NOT NULL,
  [couponValue] varchar(50) NOT NULL,
  [couponStartActive] varchar(50) NOT NULL,
  [couponEndActive] varchar(50) NOT NULL,
  [couponLocationsZip] varchar(50) NOT NULL
) ;
/*
DROP TABLE IF EXISTS [genadx`.`log];

CREATE TABLE log (
  [Id] int NOT NULL,
  [Date] datetime2(0) NOT NULL,
  [Thread] varchar(255) NOT NULL,
  [Level] varchar(50) NOT NULL,
  [Logger] varchar(255) NOT NULL,
  [Message] varchar(4000) NOT NULL,
  [Exception] varchar(2000) DEFAULT NULL
) ;

DROP TABLE IF EXISTS [genadx`.`preference];
*/
CREATE TABLE preference (
  [preferenceID] int DEFAULT NULL,
  [preferenceGsSegment] int DEFAULT NULL,
  [preferenceCaTypeCode] int DEFAULT NULL,
  [preferenceCaValueCode] int DEFAULT NULL,
  [preferenceBrandOwner] varchar(50) DEFAULT NULL,
  [preferenceProductDesc] varchar(50) DEFAULT NULL,
  [preferenceDate] varchar(50) DEFAULT NULL,
  [consumerID] int DEFAULT NULL
) ;
/*
DROP TABLE IF EXISTS [genadx`.`myads];
*/
CREATE TABLE myads (
  [adID] int DEFAULT NULL,
  [adURL] varchar(200) NOT NULL,
  [adPCC] varchar(50) NOT NULL,
  [adtitle] varchar(50) NOT NULL,
  [addescription] varchar(50) NOT NULL,
  [adowner] varchar(50) NOT NULL,
  [couponID] int DEFAULT NULL,
  [couponURL] varchar(200) NOT NULL,
  [couponTitle] varchar(50) NOT NULL,
  [couponDescription] varchar(50) NOT NULL,
  [couponValue] varchar(50) NOT NULL
) ;
/*
DROP TABLE IF EXISTS [genadx`.`login];
*/
CREATE TABLE login (
  [UserName] varchar(100) NOT NULL ,
  [PassWord] varchar(100) NOT NULL,
  PRIMARY KEY ([UserName])
) ;
/*
INSERT INTO genadx.login (UserName,PassWord) VALUES
("Jason", "Canney");

INSERT INTO genadx.login (UserName,PassWord) VALUES
("admin", "admin");
*/
