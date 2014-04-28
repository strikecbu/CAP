INSERT INTO CFG_SYSPARM (PARMID,PARMDESC,PARMVALUE,UPDATETIME,UPDATER) VALUES ('pwd_expired_day','密碼有效期限','90',current timestamp,'System');
INSERT INTO CFG_SYSPARM (PARMID,PARMDESC,PARMVALUE,UPDATETIME,UPDATER) VALUES ('pwd_min_length','密碼最小長度','8',current timestamp,'System');
INSERT INTO CFG_SYSPARM (PARMID,PARMDESC,PARMVALUE,UPDATETIME,UPDATER) VALUES ('pwd_rule','密碼字元規則','4',current timestamp,'System');
INSERT INTO CFG_SYSPARM (PARMID,PARMDESC,PARMVALUE,UPDATETIME,UPDATER) VALUES ('pwd_max_history','密碼歷史紀錄','5',current timestamp,'System');
INSERT INTO CFG_SYSPARM (PARMID,PARMDESC,PARMVALUE,UPDATETIME,UPDATER) VALUES ('pwd_captcha_enable','圖形驗證碼啟用條件','5',current timestamp,'System');
INSERT INTO CFG_SYSPARM (PARMID,PARMDESC,PARMVALUE,UPDATETIME,UPDATER) VALUES ('pwd_account_lock','帳戶暫禁條件','7',current timestamp,'System');
INSERT INTO CFG_SYSPARM (PARMID,PARMDESC,PARMVALUE,UPDATETIME,UPDATER) VALUES ('pwd_force_change_pwd','首次登入是否強制更換密碼','1',current timestamp,'System');
INSERT INTO CFG_SYSPARM (PARMID,PARMDESC,PARMVALUE,UPDATETIME,UPDATER) VALUES ('pwd_change_interval','連續兩次密碼修改時間最小間隔','7',current timestamp,'System');
