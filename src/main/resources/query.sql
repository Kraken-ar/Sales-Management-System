--create table product(
--id INTEGER  primary key,
--name TEXT,
--qnt INTEGER,
--unitePrice double,
--code TEXT NULL,
--buyDate TIMESTAMP  CURRENT_TIMESTAMP
--
--);
--
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (2, 'Ibuprofen', 150, 0.75, 'IBP002', '2024-01-02 10:30:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (3, 'Amoxicillin', 100, 1.20, 'AMX003', '2024-01-03 11:00:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (4, 'Cough Syrup', 80, 3.50, 'CFS004', '2024-01-04 08:45:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (5, 'Vitamin C', 300, 0.30, 'VTC005', '2024-01-05 09:15:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (6, 'Aspirin', 250, 0.40, 'ASP006', '2024-01-06 14:20:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (7, 'Cetirizine', 120, 0.80, 'CTZ007', '2024-01-07 12:10:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (8, 'Antibiotic Cream', 90, 5.00, 'ABC008', '2024-01-08 10:50:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (9, 'Multivitamins', 180, 0.25, 'MLT009', '2024-01-09 13:30:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (10, 'Antacid', 200, 1.50, 'ANT010', '2024-01-10 09:40:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (11, 'Loratadine', 140, 0.65, 'LOR011', '2024-01-11 11:15:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (12, 'Metformin', 70, 2.30, 'MET012', '2024-01-12 08:50:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (13, 'Glucometer Strips', 500, 0.10, 'GLM013', '2024-01-13 12:45:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (14, 'Bandages', 600, 0.15, 'BND014', '2024-01-14 15:00:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (15, 'Antiseptic Solution', 120, 3.10, 'ATS015', '2024-01-15 14:00:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (16, 'Antifungal Cream', 100, 4.50, 'AFC016', '2024-01-16 09:25:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (17, 'Oral Rehydration Salts', 250, 0.40, 'ORS017', '2024-01-17 13:00:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (18, 'Saline Nasal Spray', 90, 2.80, 'SNS018', '2024-01-18 10:10:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (19, 'Eye Drops', 70, 6.00, 'EYD019', '2024-01-19 11:50:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (20, 'Inhaler', 150, 10.50, 'INH020', '2024-01-20 09:35:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (21, 'Hydrocortisone Cream', 60, 7.00, 'HCC021', '2024-01-21 12:20:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (22, 'Blood Pressure Monitor', 30, 45.00, 'BPM022', '2024-01-22 15:40:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (23, 'Antihistamine', 100, 1.00, 'ATH023', '2024-01-23 09:05:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (24, 'Nasal Decongestant', 200, 2.20, 'NSD024', '2024-01-24 14:30:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (25, 'Cough Lozenges', 300, 0.10, 'CFL025', '2024-01-25 09:50:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (26, 'Pain Relief Patch', 80, 3.80, 'PRP026', '2024-01-26 13:40:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (27, 'Insulin Syringes', 500, 0.20, 'INS027', '2024-01-27 12:00:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (28, 'Thermometer', 100, 8.00, 'THR028', '2024-01-28 11:25:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (29, 'Digital Weighing Scale', 50, 25.00, 'DWS029', '2024-01-29 08:40:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (30, 'Pregnancy Test Kit', 200, 2.50, 'PTK030', '2024-01-30 09:55:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (31, 'Antiviral Tablets', 100, 12.00, 'AVT031', '2024-01-31 13:50:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (32, 'Cold and Flu Tablets', 250, 1.10, 'CFT032', '2024-02-01 10:00:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (33, 'Ointment for Burns', 70, 5.50, 'BNO033', '2024-02-02 11:40:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (34, 'Calamine Lotion', 90, 3.30, 'CAL034', '2024-02-03 15:25:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (35, 'Probiotic Capsules', 150, 0.90, 'PBC035', '2024-02-04 10:15:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (36, 'Antimicrobial Hand Gel', 200, 1.70, 'AHG036', '2024-02-05 11:50:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (37, 'First Aid Kit', 60, 20.00, 'FAK037', '2024-02-06 13:30:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (38, 'Wound Dressing', 120, 2.90, 'WND038', '2024-02-07 14:40:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (39, 'Sunscreen SPF 50', 180, 9.50, 'SSC039', '2024-02-08 12:10:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (40, 'Oral Antibiotics', 100, 7.20, 'OAB040', '2024-02-09 09:30:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (41, 'Antimalarial Tablets', 90, 3.00, 'AMT041', '2024-02-10 10:25:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (42, 'Sterile Gloves', 300, 0.50, 'STG042', '2024-02-11 11:45:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (43, 'Nebulizer', 40, 35.00, 'NEB043', '2024-02-12 09:50:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (44, 'Hand Sanitizer', 250, 2.10, 'HDS044', '2024-02-13 12:00:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (45, 'Face Mask', 1000, 0.10, 'FMS045', '2024-02-14 08:40:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (46, 'Ear Drops', 80, 5.00, 'ERD046', '2024-02-15 11:20:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (47, 'Tetanus Injection', 70, 15.00, 'TIN047', '2024-02-16 12:30:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (48, 'Surgical Tape', 120, 1.50, 'SGT048', '2024-02-17 14:05:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (49, 'Sterile Gauze Pads', 400, 0.20, 'SGP049', '2024-02-18 13:15:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (50, 'Medical Adhesive Strips', 300, 0.35, 'MAS050', '2024-02-19 11:30:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (51, 'Hydrogen Peroxide', 100, 1.20, 'HYP051', '2024-02-20 10:00:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (52, 'Diabetes Test Kit', 60, 25.00, 'DTK052', '2024-02-21 12:40:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (53, 'Folic Acid Tablets', 180, 0.45, 'FAT053', '2024-02-22 14:20:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (54, 'Calcium Supplements', 150, 0.70, 'CAS054', '2024-02-23 09:35:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (55, 'Zinc Supplements', 160, 0.55, 'ZSS055', '2024-02-24 08:45:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (56, 'Vitamin D3', 140, 0.90, 'VTD056', '2024-02-25 10:30:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (57, 'Omega-3 Capsules', 130, 1.50, 'O3C057', '2024-02-26 11:10:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (58, 'Cranberry Pills', 120, 3.20, 'CRP058', '2024-02-27 09:50:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (59, 'Echinacea Tablets', 150, 2.10, 'ECT059', '2024-02-28 10:45:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (60, 'Vitamin B12', 180, 0.60, 'VIB060', '2024-03-01 11:25:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (61, 'Vitamin E Capsules', 140, 1.20, 'VEC061', '2024-03-02 12:40:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (62, 'Fish Oil Capsules', 130, 1.75, 'FOC062', '2024-03-03 08:30:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (63, 'Aloe Vera Gel', 90, 3.40, 'AVG063', '2024-03-04 09:10:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (64, 'Antiseptic Wipes', 300, 0.10, 'ASW064', '2024-03-05 09:50:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (65, 'Antibacterial Soap', 200, 1.00, 'ABS065', '2024-03-06 11:15:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (66, 'Nail Fungus Treatment', 80, 4.50, 'NFT066', '2024-03-07 12:05:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (67, 'Wound Closure Strips', 150, 0.80, 'WCS067', '2024-03-08 10:35:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (68, 'Pain Relieving Gel', 100, 5.20, 'PRG068', '2024-03-09 14:50:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (69, 'Electrolyte Tablets', 120, 2.50, 'ELT069', '2024-03-10 11:30:00');
--INSERT INTO product (id, name, qnt, unitePrice, code, buyDate) VALUES (70, 'Joint Support Supplement', 70, 6.00, 'JSS070', '2024-03-11 10:20:00');
--
--INSERT INTO product ( name, qnt, unitePrice, code, buyDate) VALUES ( 'Immune Booster', 150, 2.00, '', '2024-03-12 09:55:00');
--INSERT INTO product ( name, qnt, unitePrice, code, buyDate) VALUES ( 'Antibacterial Mouthwash', 90, 3.00, '', '2024-03-13 14:40:00');
--INSERT INTO product ( name, qnt, unitePrice, code, buyDate) VALUES ( 'Bacitracin Ointment', 70, 4.20, 'BTO073', '2024-03-14 12:50:00');
--INSERT INTO product ( name, qnt, unitePrice, code, buyDate) VALUES ( 'Charcoal Tablets', 200, 1.20, '', '2024-03-15 10:05:00');
--INSERT INTO product ( name, qnt, unitePrice, code, buyDate) VALUES ( 'Cold Compress', 50, 8.00, 'CLD075', '2024-03-16 13:20:00');
--INSERT INTO product ( name, qnt, unitePrice, code, buyDate) VALUES ( 'Aloe Vera Juice', 80, 5.00, '', '2024-03-17 09:25:00');
--INSERT INTO product ( name, qnt, unitePrice, code, buyDate) VALUES ( 'Honey and Lemon Cough Syrup', 100, 3.60, 'HCS077', '2024-03-18 11:45:00');
--INSERT INTO product ( name, qnt, unitePrice, code, buyDate) VALUES ( 'Herbal Tea', 150, 2.50, 'HBT078', '2024-03-19 09:10:00');
--INSERT INTO product ( name, qnt, unitePrice, code, buyDate) VALUES ( 'Antiseptic Mouthwash', 60, 4.00, '', '2024-03-20 12:25:00');
--INSERT INTO product ( name, qnt, unitePrice, code, buyDate) VALUES ( 'Cough Suppressant', 100, 3.30, 'CSP080', '2024-03-21 14:50:00');
--INSERT INTO product ( name, qnt, unitePrice, code, buyDate) VALUES ( 'Cold Sore Treatment', 70, 7.50, '', '2024-03-22 10:40:00');
--INSERT INTO product ( name, qnt, unitePrice, code, buyDate) VALUES ( 'Mouth Ulcer Gel', 80, 3.90, '', '2024-03-23 09:00:00');
--INSERT INTO product ( name, qnt, unitePrice, code, buyDate) VALUES ( 'Scar Reducing Cream', 60, 9.00, '', '2024-03-24 10:30:00');
--INSERT INTO product ( name, qnt, unitePrice, code, buyDate) VALUES ( 'Digestive Enzymes', 100, 5.50, '', '2024-03-25 13:00:00');
--INSERT INTO product ( name, qnt, unitePrice, code, buyDate) VALUES ( 'Laxatives', 120, 1.80, 'LXT085', '2024-03-26 11:15:00');
--INSERT INTO product ( name, qnt, unitePrice, code, buyDate) VALUES ( 'Antifungal Shampoo', 50, 6.20, 'AFS086', '2024-03-27 09:35:00');
--INSERT INTO product ( name, qnt, unitePrice, code, buyDate) VALUES ( 'Ear Syringe', 90, 2.80, '', '2024-03-28 12:50:00');
--INSERT INTO product ( name, qnt, unitePrice, code, buyDate) VALUES ( 'Oral Care Spray', 110, 3.00, '', '2024-03-29 14:00:00');
--INSERT INTO product ( name, qnt, unitePrice, code, buyDate) VALUES ( 'Stomach Relief Tablets', 150, 2.20, '', '2024-03-30 11:40:00');
--INSERT INTO product ( name, qnt, unitePrice, code, buyDate) VALUES ( 'Herbal Cough Drops', 200, 0.50, '', '2024-03-31 10:10:00');
--INSERT INTO product ( name, qnt, unitePrice, code, buyDate) VALUES ( 'Probiotic Powder', 60, 5.30, '', '2024-04-01 09:50:00');
--INSERT INTO product ( name, qnt, unitePrice, code, buyDate) VALUES ( 'Herbal Ointment', 70, 4.90, 'HBO092', '2024-04-02 11:05:00');
--INSERT INTO product ( name, qnt, unitePrice, code, buyDate) VALUES ( 'Detox Foot Pads', 80, 6.50, 'DFP093', '2024-04-03 12:30:00');
--INSERT INTO product ( name, qnt, unitePrice, code, buyDate) VALUES ( 'Anti-inflammatory Cream', 90, 5.80, 'AIC094', '2024-04-04 10:20:00');
--INSERT INTO product ( name, qnt, unitePrice, code, buyDate) VALUES ( 'Muscle Relaxant Gel', 60, 7.30, 'MRG095', '2024-04-05 09:15:00');
--INSERT INTO product ( name, qnt, unitePrice, code, buyDate) VALUES ( 'Antifungal Powder', 100, 3.40, '', '2024-04-06 11:40:00');
--INSERT INTO product ( name, qnt, unitePrice, code, buyDate) VALUES ( 'Hair Growth Serum', 70, 10.00, '', '2024-04-07 13:50:00');
--INSERT INTO product ( name, qnt, unitePrice, code, buyDate) VALUES ( 'Sleep Aid Capsules', 150, 4.50, '', '2024-04-08 09:40:00');
--INSERT INTO product ( name, qnt, unitePrice, code, buyDate) VALUES ( 'Joint Pain Patches', 80, 6.00, '', '2024-04-09 10:35:00');
--INSERT INTO product ( name, qnt, unitePrice, code, buyDate) VALUES ( 'Hemorrhoid Cream', 90, 7.80, 'HRC100', '2024-04-10 12:15:00');
--
--
--
--
--
--


create table invoice(
	id integer primary key,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


create table sale (
	id integer primary key,

	product_name TEXT null,
	unitePrice float,
	qnt int,
	invoice_id integer ,
	product_id integer null,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (invoice_id) REFERENCES invoice(id),
	FOREIGN KEY (product_id) REFERENCES product(id)
);

