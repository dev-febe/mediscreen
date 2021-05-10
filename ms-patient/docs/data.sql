SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";

START TRANSACTION;
SET time_zone = "+00:00";

CREATE TABLE Patient (
  id tinyint(4) NOT NULL AUTO_INCREMENT,
  family VARCHAR(30) NOT NULL,
  given VARCHAR(30) NOT NULL,
  dob TIMESTAMP NOT NULL,
  sex ENUM('F', 'M'),
  address VARCHAR(30),
  phone VARCHAR(30),
  PRIMARY KEY (id)
);


INSERT INTO Patient(`family`, `given`, `dob`, `sex`, `address`, `phone`) VALUES
('Ferguson', 'Lucas', TIMESTAMP '1968-06-22 00:00:00.871+00:00', 'M', '2 Warren Street ', '387-866-1399'),
('Rees', 'Pippa', TIMESTAMP '1952-09-27 00:00:00.871+00:00', 'F', '745 West Valley Farms Drive', '628-423-0993'),
('Arnold', 'Edward', TIMESTAMP '1952-11-11 00:00:00.871+00:00', 'M', '599 East Garden Ave', '123-727-2779'),
('Sharp', 'Anthony', TIMESTAMP '1946-11-26 00:00:00.871+00:00', 'M', '894 Hall Street', '451-761-8383'),
('Ince', 'Wendy', TIMESTAMP '1958-06-29 00:00:00.871+00:00', 'F', '4 Southampton Road', '802-911-9975'),
('Ross', 'Tracey', TIMESTAMP '1949-12-07 00:00:00.871+00:00', 'F', '40 Sulphur Springs Dr', '131-396-5049'),
('Wilson', 'Claire', TIMESTAMP '1966-12-31 00:00:00.871+00:00', 'F', '12 Cobblestone St', '300-452-1091'),
('Buckland ', 'Max', TIMESTAMP '1945-06-24 00:00:00.871+00:00', 'M', '193 Vale St', '833-534-0864'),
('Clark ', 'Natalie', TIMESTAMP '1964-06-18 00:00:00.871+00:00', 'F', '12 Beechwood Road', '241-467-9197'),
('Bailey ', 'Piers', TIMESTAMP '1959-06-28 00:00:00.871+00:00', 'M', '1202 Bumble Dr', '747-815-0557');

COMMIT;
