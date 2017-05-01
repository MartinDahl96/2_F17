


CREATE TABLE matador.Player ( 
PlayerID INT(1) NOT NULL, 
playerName VARCHAR(20), 
fortune INT(7),
immunity BIT(1),
totalAssets INT(6), 
ownedFerries INT(1), 
ownedBreweries INT(1),
jailRounds INT(1),
jailtoken INT(1),
currentPosition INT(2),
PRIMARY KEY (PlayerID),
UNIQUE INDEX PlayerID_UNIQUE (PlayerID ASC));
					
INSERT INTO matador.Ownable (
PlayerID,fieldID,
Owner,
houses,
Pawned VALUES (?,?,?,?,?), 
ON DUPLICATE KEY UPDATE PlayerID = VALUES(PlayerID),
fieldID = VALUES(fieldID),
Owner = VALUES(Owner),
Houses = VALUES(Houses),
Pawned = VALUES(Pawned);	

CREATE TABLE field(
`fieldID` INT(2) NOT NULL,
`PlayerID` INT(1) NOT NULL,
PRIMARY KEY (`fieldID`), 
FOREIGN KEY (`PlayerID`) REFERENCES Player(PlayerID));
);

CREATE TABLE ChanceDeck(
`CardID` INT(2) NOT NULL,
`CardText` VARCHAR(150) NOT NULL,
`CardValue` INT(5) NOT NULL,
PRIMARY KEY (`CardID`)
);

CREATE TABLE Ownable (
`PlayerID` INT(1) NOT NULL,
`fieldID` INT(2) NOT NULL,
`Owner` INT(1),
`Houses` INT(1) DEFAULT NULL,
`Pawned` BIT(1),
PRIMARY KEY (`fieldID`),
FOREIGN KEY (`Owner`) REFERENCES Player(PlayerID),
UNIQUE INDEX `fieldID_UNIQUE` (`FieldID` ASC)
);

INSERT INTO matador.Player (
playerID,
playerName,
fortune,
immunity,
totalAssets,
ownedFerries,
ownedBreweries,
jailRounds,
jailToken,
currentPosition
VALUES (?,?,?,?,?,?,?,?,?,?)
ON DUPLICATE KEY UPDATE 
playerID = VALUES(playerID),
playerName = VALUES(playerName),
fortune = VALUES(fortune),
immunity = VALUES(immunity),
totalAssets = VALUES(totalAssets),
ownedFerries = VALUES(ownedFerries), 
ownedBreweries = VALUES(ownedBreweries), 
jailRounds = VALUES(jailRounds), 
jailToken = VALUES(jailToken), 
currentPosition = VALUES(currentPosition), 
ON DUPLICATE KEY UPDATE PlayerID = VALUES(PlayerID), 
playerName = VALUES(playerName),
fortune = VALUES(fortune),
immunity = VALUES(immunity), 
totalAssets = VALUES(totalAssets),
ownedFerries =VALUES(ownedFerries), 
ownedBreweries = VALUES(ownedBreweries),
jailRounds = VALUES(jailRounds), 
jailToken = VALUES(jailToken), 
currentPosition = VALUES(currentPosition));