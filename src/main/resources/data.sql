INSERT INTO USER (username, password, enable) VALUES ( 'AAAA', 'FKGPRWOFJWOPIRWFEFW', true),
                                                     ('BBBB', 'SDFSDFWFWEFWEF', true),
                                                     ('CCCC', 'SDFWEFWEFWEFWEFEW', true);

INSERT INTO ACCOUNT (user_id, balance) VALUES (1, 12312),
                                              (2, 56764),
                                              (3, 21341);

INSERT INTO CARD (account_id, spending_limit, card_number) VALUES (1, 20000, '1234567890987654'),
                                                                  (2, 20000, '6547890213456789'),
                                                                  (3, 20000, '1789054678345629');