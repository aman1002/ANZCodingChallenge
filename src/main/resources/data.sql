INSERT INTO account (account_number, account_name, account_type, balance_date, currency_code, opening_available_balance)
VALUES
	('585309209', 'SGSAVINGS726', 'SAVINGS', now(), 'SGD', 84327.51),
	('791066619', 'AUSAVINGS933', 'SAVINGS', now(), 'AUD', 88005.93),
	('321143048', 'AUCURRENT433', 'CURRENT', now(), 'AUD', 38010.62),
	('347546123', 'SGCURRENT166', 'CURRENT', now(), 'SGD', 50664.65),
	('680456441', 'AUCURRENT374', 'CURRENT', now(), 'AUD', 41327.28),
	('136151648', 'AUCURRENT938', 'SAVINGS', now(), 'AUD', 48928.79),
	('453489511', 'SGSAVINGS842', 'SAVINGS', now(), 'SGD', 72117.53),
	('334651897', 'AUSAVINGS253', 'SAVINGS', now(), 'AUD', 20588.16),
	('793445614', 'AUCURRENT754', 'CURRENT', now(), 'AUD', 88794.48),
	('768456461', 'SGCURRENT294', 'CURRENT', now(), 'SGD', 5906.55),
	('847498496', 'AUCURRENT591', 'CURRENT', now(), 'AUD', 92561.68);


INSERT INTO transaction (account_number, account_name, credit_amount, currency_code, debit_amount, debit_credit, transaction_narrative, value_date, transaction_id)
VALUES
('847498496', 'AUCURRENT591', 9540.98, 'SGD',  null, 'CREDIT', 'Some credit',  now(), 1),
('847498496', 'AUCURRENT591', 7497.82, 'SGD',  null, 'CREDIT', 'Some credit',  now(), 2),
('847498496', 'AUCURRENT591', 5464.79, 'SGD',  null, 'CREDIT', 'Some credit',  now(), 3),
('847498496', 'AUCURRENT591', 8136.18, 'SGD',  null, 'CREDIT', 'Some credit',  now(), 4),
('847498496', 'AUCURRENT591', 9442.46, 'SGD',  null, 'CREDIT', 'Some credit',  now(), 5),
('585309209', 'SGSAVINGS726', null, 'AUD',  7614.45, 'DEBIT', 'Some debit',  now(), 6),
('585309209', 'SGSAVINGS726', null, 'AUD',  3311.55, 'DEBIT', 'Some debit',  now(), 7),
('585309209', 'SGSAVINGS726', null, 'AUD',  9186.09, 'DEBIT', 'Some debit',  now(), 8),
('585309209', 'SGSAVINGS726', null, 'AUD',  1905.86, 'DEBIT', 'Some debit',  now(), 9),
('585309209', 'SGSAVINGS726', null, 'AUD',  197.78, 'DEBIT'	, 'Some debit',  now(), 10);