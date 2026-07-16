USE fyndr_db;

CREATE USER IF NOT EXISTS 'fyndr_admin'@'localhost' IDENTIFIED BY 'AdminPassword123!';
GRANT ALL PRIVILEGES ON fyndr_db.* TO 'fyndr_admin'@'localhost';
CREATE USER IF NOT EXISTS 'fyndr_app'@'localhost' IDENTIFIED BY 'AppPassword123!';
GRANT SELECT, INSERT, UPDATE, DELETE ON fyndr_db.* TO 'fyndr_app'@'localhost';
FLUSH PRIVILEGES;
