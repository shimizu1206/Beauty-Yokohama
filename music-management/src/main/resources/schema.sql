CREATE TABLE shops (--店舗情報
    shop_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    shop_name VARCHAR(255) NOT NULL,--店舗名
    opening_hours VARCHAR(255),--営業時間
    shop_address VARCHAR(255),--住所
    price_range VARCHAR(255) DEFAULT '--~--',--価格帯
    picture VARCHAR(255),
    message VARCHAR(255)
);
CREATE TABLE staff (--美容師情報
    staff_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    staff_name VARCHAR(255) NOT NULL,--美容師名
    gender VARCHAR(255),--性別
    age INTEGER,--年齢
    specialty VARCHAR(255),--得意なスタイル
    Career INTEGER,--経歴
    hobby VARCHAR(255),--趣味
    shop_id INTEGER NOT NULL,
    picture VARCHAR(255),
    comment VARCHAR(255),
    FOREIGN KEY (shop_id) REFERENCES shops(shop_id)ON DELETE CASCADE --参照
);
CREATE TABLE menus (--メニュー情報
    menu_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    menu VARCHAR(255) NOT NULL,--メニュー
    price INTEGER NOT NULL,--値段
    cut_time VARCHAR,--施術時間
    shop_id INTEGER NOT NULL,
    menu_message VARCHAR(255),
    FOREIGN KEY (shop_id) REFERENCES shops(shop_id)ON DELETE CASCADE --参照
);

CREATE TABLE reserve (--予約情報
    reserve_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    shop_name VARCHAR(255) NOT NULL,--店舗名
    user_name VARCHAR(255) NOT NULL,--利用者名
    staff_name VARCHAR(255),--美容師名
    menu VARCHAR(255),--メニュー
    price INTEGER,--値段
    Date_and_Time TIMESTAMP UNIQUE,--予約日時
    item VARCHAR(255),--購入品
    shop_id INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    FOREIGN KEY (shop_id) REFERENCES shops(shop_id)ON DELETE CASCADE --参照
        
);
CREATE TABLE items (--商品情報
    item_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    item_name VARCHAR(255) NOT NULL,--商品名
    price INTEGER NOT NULL,--値段
    features VARCHAR(255),--商品説明
    shop_id INTEGER NOT NULL,
    picture VARCHAR(255),
    FOREIGN KEY (shop_id) REFERENCES shops(shop_id)ON DELETE CASCADE --参照
);
CREATE TABLE users (
    user_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(60) NOT NULL,
    user_address VARCHAR(255),
    user_check BOOLEAN,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE kutis (
   kuti_id INTEGER AUTO_INCREMENT PRIMARY KEY,
   age VARCHAR(255) NOT NULL,
   gender VARCHAR(255) ,
   kansou VARCHAR(255) ,
   shop_id INTEGER NOT NULL,
   evaluate FLOAT
);

