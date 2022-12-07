INSERT INTO television (id, type, brand, price, available_size, refresh_rate, screen_type, screen_quality, smart_tv, wifi, voice_control, hdr, bluetooth, ambi_light, original_stock, sold) VALUES (1001, 'NH3216SMART', 'Nikkei', 159, 32, 100, 'LED', 'HD ready', true, true,false,false,false,false, 235885, 45896);
INSERT INTO television (id, type, brand, price, available_size, refresh_rate, screen_type, screen_quality, smart_tv, wifi, voice_control, hdr, bluetooth, ambi_light, original_stock, sold) VALUES (1002, '43PUS6504/12/L', 'Philips', 379, 43, 60, 'LED', 'Ultra HD', true, true, false, false, false, false, 8569452, 5685489);
INSERT INTO television (id, type, brand, price, available_size, refresh_rate, screen_type, screen_quality, smart_tv, wifi, voice_control, hdr, bluetooth, ambi_light, original_stock, sold) VALUES (1003, '43PUS6504/12/M', 'Philips', 379, 50, 60, 'LED', 'Ultra HD', true, true, false, true, false, false, 435549,2424486);
INSERT INTO television (id, type, brand, price, available_size, refresh_rate, screen_type, screen_quality, smart_tv, wifi, voice_control, hdr, bluetooth, ambi_light, original_stock, sold) VALUES (1004, '43PUS6504/12/S', 'Philips', 379, 58, 60, 'LED', 'Ultra HD', true, true, false, true, false, false, 655549,8524486);
INSERT INTO television (id, type, brand, price, available_size, refresh_rate, screen_type, screen_quality, smart_tv, wifi, voice_control, hdr, bluetooth, ambi_light, original_stock, sold) VALUES (1005, 'OLED55C16LA', 'LG', 989, 55, 100, 'OLED', 'Ultra HD', true, true, true, true, true, false, 435549, 20500);

INSERT INTO remote_controller (id, compatible_with, battery_type, name, brand, price, original_stock) VALUES (1001, 'NH3216SMRT', 'AAA', 'Nikkei HD smart tv controller', 'Nikkei', 12.99, 235885);
INSERT INTO wall_bracket (id, size, ajustable, name, price) VALUES (1001, '323', true, 'HP', 3000.99);

UPDATE television SET remote_controller_id = 1001 WHERE television.id = 1001;

INSERT INTO television_wall_bracket (television_id, wall_bracket_id) VALUES (1001, 1001);
INSERT INTO ci_module (id,name ,type ,price, television_id) VALUES (1001, 'HP', 'HP-p', 399.99, 1001);
