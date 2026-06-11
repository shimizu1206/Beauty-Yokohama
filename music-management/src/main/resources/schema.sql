--//データベースの大元
CREATE TABLE albums (
    album_id INTEGER AUTO_INCREMENT PRIMARY KEY, --AUTO_INCREMENTはalbumidに値が入っていない場合でも自動的に+1される
                                                --PRIMARYKEYは重複させない--主キーの設定?
    title VARCHAR(255) NOT NULL,                --nullになるのを許可しない
    artist VARCHAR(255) ,                       --文字列を格納
    release_date DATE,                          --年月日のみ
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP--年月日と時間,デフォルトで、現在の日付や時間を呼び出す
);
CREATE TABLE musics (
    music_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    duration TIME,                               --時間だけ、日付はなし
    album_id INTEGER NOT NULL,                  
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (album_id) REFERENCES albums(album_id)ON DELETE CASCADE --参照
);

CREATE TABLE shops (--店舗情報
    shop_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    shop_name VARCHAR(255) NOT NULL,--店舗名
    opening_hours TIME,--営業時間
    shop_address VARCHAR(255),--住所
    price_range VARCHAR(255) DEFAULT '--~--'--価格帯
);
CREATE TABLE staff (--美容師情報
    staff_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    staff_name VARCHAR(255) NOT NULL,--美容師名
    gender VARCHAR(255),--性別
    age INTEGER,--年齢
    specialty VARCHAR(255) NOT NULL,--得意なスタイル
    Career INTEGER,--経歴
    hobby VARCHAR(255),--趣味
    shop_id INTEGER NOT NULL,
    FOREIGN KEY (shop_id) REFERENCES shops(shop_id)ON DELETE CASCADE --参照
);
CREATE TABLE menus (--メニュー情報
    menu_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    menu VARCHAR(255) NOT NULL,--メニュー
    price INTEGER NOT NULL,--値段
    cut_time INTEGER,--施術時間
    shop_id INTEGER NOT NULL,
    FOREIGN KEY (shop_id) REFERENCES shops(shop_id)ON DELETE CASCADE --参照
);
CREATE TABLE reserve (--予約情報
    reserveshop_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    shop_name VARCHAR(255) NOT NULL,--店舗名
    user_name VARCHAR(255) NOT NULL,--利用者名
    staff_name VARCHAR(255),--美容師名
    manu VARCHAR(255),--メニュー
    price INTEGER,--値段
    Date_and_Time TIMESTAMP,--予約日時
    item VARCHAR(255)--購入品  
);
CREATE TABLE items (--商品情報
    item_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    item_name VARCHAR(255) NOT NULL,--商品名
    price INTEGER NOT NULL,--値段
    features VARCHAR(255),--特徴
    stock INTEGER,--在庫
    shop_id INTEGER NOT NULL,
    FOREIGN KEY (shop_id) REFERENCES shops(shop_id)ON DELETE CASCADE --参照
);
CREATE TABLE users (--ユーザー情報
    user_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL,
    user_password VARCHAR(255) NOT NULL
);

