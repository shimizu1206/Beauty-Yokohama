--ここで、具体的な要素を入れていく
INSERT INTO shops (shop_name, opening_hours, shop_address,price_range) VALUES
  ('サイコム美容室', '10:00~21:00', '〇県〇市〇町','1000~5000'),
  ('美容室yokohama', '9:00~22:00', '〇県〇市〇町','2000~7000'),
  ('cut横浜', '10:00~21:30', '〇県〇市〇町','3000~10000'),
  ('Haircut横浜', '10:00~22:30', '〇県〇市〇町','3000~15000'),
  ('横浜style', '8:00~21:30', '〇県〇市〇町','3000~10000');

INSERT INTO staff (staff_name, gender, age,specialty,career,hobby,shop_id) VALUES
  ('takeru', '男性', 30,'パーマ',5,'キャンプ',1),
  ('rei', '女性', 23,'パーマ',3,'ギター',1),
  ('masato', '男性', 28,'パーマ',8,'音楽',2),
  ('siori', '女性', 27,'パーマ',5,'映画',2),
  ('tanaka', '男性', 31,'パーマ',10,'旅行',3),
  ('eri', '女性', 25,'パーマ',1,'読書',3);


INSERT INTO menus (menu, price, cut_time,shop_id) VALUES
  ('カットのみ', 4000, '1時間',1),
  ('カットシャンプー', 5000, '1時間30分',2),
  ('カットカラー、', 10000, '2時間',3);

INSERT INTO items (item_name, price, features,stock,shop_id) VALUES
  ('シャンプー', 2000, '「 髪の毛をサラサラに 」',10,1),
  ('リンス', 2000, '「 つやつやに 」',20,2),
  ('ワックス', 3000, '「 濡れ感のある髪に 」',30,3);