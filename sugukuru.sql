-- IH31 スグクルDB
--
-- DB、ユーザ作成SQLファイル
-- rootユーザで使用
-- コマンド: mysql -u root --default-character-set=utf8 -p < "C:\…\ScottAdminDB-MySQL_dbinit1.sql"
--
-- @author I.Asakawa

- DB作成
CREATE DATABASE ss_sugukuru CHARACTER SET utf8;

-- ユーザ作成(権限付与)
GRANT ALL PRIVILEGES ON javawebdb.* TO admin@localhost IDENTIFIED BY 'password' WITH GRANT OPTION;