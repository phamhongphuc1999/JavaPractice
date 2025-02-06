CREATE DATABASE IF NOT EXISTS word_app;
GO

USE word_app;
GO

CREATE TABLE user (
  id INT NOT NULL AUTO_INCREMENT,
  display_name VARCHAR(50),
  username VARCHAR(100),
  password VARCHAR(100),
  PRIMARY KEY (id)
);
GO

CREATE TABLE category (
  id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(50),
  user_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES user(id)
);
GO

CREATE TABLE pair (
  id INT NOT NULL AUTO_INCREMENT,
  en VARCHAR(255),
  vi VARCHAR(255),
  category_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (category_id) REFERENCES category(id)
);
GO

INSERT INTO user (display_name, username, password)
VALUES ("peter1", "peter1", "$2a$10$dyBaBpKlQpEkjx06.SqNceta6JruZNMrI1m.rcPchF0hHLPSZen16");

-- INSERT INTO category (title, user_id)
-- VALUES ("category1", 1),
--   ("category2", 1),
--   ("category3", 1),
--   ("west land", 1),
--   ("scholar", 1),
--   ("desertification1", 1),
--   ("desertification2", 1),
--   ("desertification3", 1),
--   ("category4", 1),
--   ("category5", 1);

-- INSERT INTO pair (en, vi, category_id)
-- VALUES ("countenance", "vẻ mặt", 1),
--   ("visionary", "tầm nhìn xa", 1),
--   ("sculptor", "nhà điêu khắc", 1),
--   ("federal government", "chính phủ liên bang", 1),
--   ("undaunted", "không nao núng", 1),
--   ("obstacle", "khó khăn", 1),
--   ("assert", "nhất quyết, khẳng định", 1),
--   ("dynamite", "nổ, thuốc nổ", 1),
--   ("threaten", "đe doạ", 1),

--   ("consumption", "tiêu dùng", 2),
--   ("successive", "liên tiếp", 2),
--   ("geographical distance", "khoảng cách địa lý", 2),
--   ("paramount", "vô cùng quan trọng", 2),
--   ("mandatory", "bắt buộc (theo luật)", 2),
--   ("challenging", "thử thách", 2),
--   ("discouraging", "làm nản lòng", 2),

--   ("nevertheless", "tuy nhiên", 3),
--   ("ballpark figure", "số liệu ước lượng", 3),
--   ("approximate", "khoảng, ước lượng", 3),
--   ("festive", "không khí lễ hội", 3),
--   ("potion", "thuốc độc", 3),
--   ("outwork", "làm việc rất chăm chỉ", 3),
--   ("aspiring", "tham vọng", 3),
--   ("stand-up comedian", "nghệ sỹ hài độc thoại", 3),
--   ("narcissistic", "tự luyến", 3),
--   ("patient", "kiên nhẫn", 3),
--   ("excessive", "quá mức", 3),

--   ("wagon", "xe ngựa", 4),
--   ("livestock", "vật nuôi", 4),
--   ("hitch up", "kéo lại", 4),
--   ("pile", "chồng lên, đống", 4),
--   ("neophyte", "người mới, lính mới", 4),
--   ("migrant", "người di cư", 4),
--   ("preeminent", "nổi trội", 4),
--   ("pioneer", "người tiên phong", 4),
--   ("flourish", "phát triển mạnh mẽ", 4),
--   ("provision", "sự cung cấp", 4),
--   ("jump-off point", "điểm trung chuyển, điểm nhảy", 4),
--   ("prairie", "đồng cỏ", 4),
--   ("paddle-wheeler", "thuyền bánh xe chèo", 4),
--   ("momentum", "động lực", 4),

--   ("mediterranean", "Địa Trung Hải(adj, n)", 5),
--   ("stronghold", "pháo đài", 5),
--   ("commission", "uỷ quyền, nhiệm vụ", 5),
--   ("rival", "đối thủ, địch thủ", 5),
--   ("greece", "Hy Lạp", 5),
--   ("mythical", "thần thoại", 5),
--   ("hearsay", "tin đồn", 5),
--   ("supposition", "giả định", 5),
--   ("fruition", "kết trái", 5),
--   ("political slander", "vu khống chính trị", 5),
--   ("heyday", "thời kỳ hoàng kim", 5),
--   ("landmark", "dấu mốc", 5),
--   ("countless", "không đếm xuể", 5),
--   ("patron", "người đài thọ, tài trợ", 5),
--   ("patronage", "sự tài trợ", 5),
--   ("blaze", "ngọn lửa, bùng cháy", 5),
--   ("endowment", "tiền tài trợ", 5),
--   ("wisdom", "không ngoan", 5),
--   ("philosophical", "thuộc về triết học", 5),
--   ("ambition and drive", "tham vọng và động lực", 5),
--   ("scientific", "thuộc về khoa học (adj)", 5),
--   ("manuscript", "bản thảo", 5),

--   ("desertification", "xa mạc hoá", 6),
--   ("alarming pace", "tốc độ báo động", 6),
--   ("dimeter", "đường kính", 6),
--   ("accomplish primarily", "thược hiện chủ yếu", 6),
--   ("acceleration", "sự tăng tốc", 6),
--   ("loose soil", "đất đá rời rạc", 6),
--   ("sand-sized particles", "hạt vật chất kích thước hạt cát", 6),
--   ("accumulation", "sự tích tụ", 6),
--   ("fine clay particles", "hạt đất sét mịn", 6),
--   ("semiarid", "bán khô hạn", 6),
--   ("aridity", "khô hạn", 6),

--   ("dissolved salt", "muối hoà tan", 7),
--   ("salinization", "muối hoá", 7),
--   ("powder", "bột", 7),
--   ("stony soid", "đất đá", 7),
--   ("vegetation", "thảm thực vật", 7),
--   ("substantial quantities of water", "lượng nước đáng kể", 7),
--   ("penetration", "sự thâm nhập", 7),
--   ("phenomenon", "hiện tượng", 7),
--   ("runoff", "dòng chảy", 7),
--   ("climatic condition", "tình trạng khí hậu", 7),

--   ("over-cultivation", "canh tác quá mức", 8),
--   ("overgrazing", "hái lượng quá mức", 8),
--   ("over-irrigation", "tưới tiêu quá mức", 8),
--   ("evaporation", "bốc hơi", 8),
--   ("firewood gathering", "thu thập củi", 8),
--   ("susceptible", "dễ bị tổn thương", 8),
--   ("raindrop", "giọt mưa", 8),

--   ("wool", "len", 9),
--   ("vague", "mơ hồ", 9),
--   ("scrub", "chà xát", 9),
--   ("sweater", "áo len", 9),
--   ("adequate", "đủ", 9),
--   ("volleyball", "bóng chuyền", 9),
--   ("thoroughly", "triệt để", 9),
--   ("scientist", "nhà khoa học", 9),
--   ("harmless", "vô hại", 9),
--   ("wholesome", "lành mạnh (adj)", 9),
--   ("wheat", "lúa mì", 9),
--   ("rash", "phát ban", 9),
--   ("hives", "nổi mề đay", 9),
--   ("headache", "đau đầu", 9),
--   ("allergic", "dị ứng", 9),
--   ("infant", "trẻ sơ sinh", 9),
--   ("breast milk", "sửa mẹ", 9),
--   ("ripe banana", "chuối chín", 9),
--   ("hyperactive", "tăng động", 9),

--   ("symbiosis", "sự cộng sinh", 10),
--   ("pine tree", "cây thông", 10),
--   ("throat", "cổ họng", 10),
--   ("bark of tree", "vỏ cây", 10),
--   ("woodpecker", "chim gõ kiến", 10),
--   ("peck", "mổ", 10),
--   ("fungus", "nấm", 10),
--   ("dwells", "cư ngụ", 10),
--   ("coffin", "quan tài", 10);
-- GO
