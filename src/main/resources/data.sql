SET @UpdateUserId = 'H2 Script';
SET @UpdateTs = '2000-01-01 00:00:00';

insert into employee_statuses (_ID, TITLE, UPDATE_USER_ID, UPDATE_TS) values
  (101, 'Full Time', @UpdateUserId, @UpdateTs),
  (102, 'Part Time', @UpdateUserId, @UpdateTs),
  (103, 'Temporary', @UpdateUserId, @UpdateTs),
  (104, 'Seasonal', @UpdateUserId, @UpdateTs),
  (105, 'Leave of Absence', @UpdateUserId, @UpdateTs),
  (106, 'Suspended with Pay', @UpdateUserId, @UpdateTs),
  (107, 'Suspended without Pay', @UpdateUserId, @UpdateTs),
  (108, 'Resigned', @UpdateUserId, @UpdateTs),
  (109, 'Terminated', @UpdateUserId, @UpdateTs);

INSERT INTO employee_types (_ID, TITLE, UPDATE_USER_ID, UPDATE_TS) VALUES
  (201, 'Associate', @UpdateUserId, @UpdateTs),
  (202, 'Vendor/Contractor', @UpdateUserId, @UpdateTs),
  (203, 'Intern', @UpdateUserId, @UpdateTs);

insert into departments (_ID, TITLE, UPDATE_USER_ID, UPDATE_TS) values
  (301, 'Board of Directors', @UpdateUserId, @UpdateTs),
  (302, 'Corporate Communications', @UpdateUserId, @UpdateTs),
  (303, 'Customer Service', @UpdateUserId, @UpdateTs),
  (304, 'Human Resources', @UpdateUserId, @UpdateTs),
  (305, 'Investor Relations', @UpdateUserId, @UpdateTs),
  (306, 'Marketing', @UpdateUserId, @UpdateTs),
  (307, 'Product Management', @UpdateUserId, @UpdateTs),
  (308, 'Quality Assurance', @UpdateUserId, @UpdateTs),
  (309, 'Sales', @UpdateUserId, @UpdateTs),
  (310, 'Technology', @UpdateUserId, @UpdateTs),
  (311, 'Asset Management', @UpdateUserId, @UpdateTs),
  (312, 'Business Development', @UpdateUserId, @UpdateTs),
  (313, 'Creative Services', @UpdateUserId, @UpdateTs),
  (314, 'General Management', @UpdateUserId, @UpdateTs),
  (315, 'Information Technology/Technology', @UpdateUserId, @UpdateTs),
  (316, 'Legal', @UpdateUserId, @UpdateTs),
  (317, 'Operations', @UpdateUserId, @UpdateTs),
  (318, 'Production', @UpdateUserId, @UpdateTs),
  (319, 'Purchasing', @UpdateUserId, @UpdateTs),
  (320, 'Sourcing', @UpdateUserId, @UpdateTs),
  (321, 'Risk Management', @UpdateUserId, @UpdateTs),
  (322, 'Strategic Initiatives & Programs', @UpdateUserId, @UpdateTs),
  (323, 'Security', @UpdateUserId, @UpdateTs),
  (324, 'Health & Wellness', @UpdateUserId, @UpdateTs),
  (325, 'Inventory', @UpdateUserId, @UpdateTs);

INSERT INTO employee_titles (_ID, TITLE, ABBREVIATION, UPDATE_USER_ID, UPDATE_TS) VALUES
  (401, 'Chief Executive Officer', 'CEO', @UpdateUserId, @UpdateTs),
  (402, 'Chief Operating Officer', 'COO', @UpdateUserId, @UpdateTs),
  (403, 'Chief Financial Officer', 'CFO', @UpdateUserId, @UpdateTs),
  (404, 'Chief Technology Officer', 'CTO', @UpdateUserId, @UpdateTs),
  (405, 'Chief Marketing Officer', 'CMO', @UpdateUserId, @UpdateTs),
  (406, 'Chief Legal Officer', 'CLO', @UpdateUserId, @UpdateTs);

INSERT INTO employees(_ID, SSN, FIRST_NAME, MIDDLE_NAME, LAST_NAME, DATE_OF_BIRTH,GENDER, START_DATE, END_DATE, SALARY, ADDRESS_LINE_1, ADDRESS_LINE_2, CITY, STATE, ZIP_CODE, PRIMARY_PHONE, SECONDARY_PHONE, EMAIL_ADDRESS, DEPARTMENT_ID, STATUS_ID, TITLE_ID, TYPE_ID, UPDATE_USER_ID, UPDATE_TS) VALUES
(1,'531-57-1883','Malcolm','V','Cremin','1977-07-25','M','2012-03-27',NULL,1736.6475,'6498 Janice Passage','54123','New Ossieside','MT','24968','1432043149','4219651691','katharina.greenholt@company.net',314,105,404,201,@UpdateUserId,@UpdateTs),
(2,'555-11-2624','Janina','I','Balistreri','1981-07-04','F','2013-06-05','2023-08-27',578.46204,'460 Huey Plaza','548','East Myrashire','MO','59974-7526','7915201219','9793398570','milan.schmidt@company.net',302,106,406,201,@UpdateUserId,@UpdateTs),
(3,'140-18-0283','Alec','III','Hodkiewicz','1967-10-01','M','1997-02-11','2023-08-30',990.0879,'0945 Legros Drive','6333','Lake Inezhaven','CA','03218','2920169314','2039963600','stanton.harris@company.net',309,103,405,203,@UpdateUserId,@UpdateTs),
(4,'863-93-5217','Jake','MD','Goldner','1979-12-09','M','2019-11-17','2023-08-11',700.0252,'939 Kacey Mills','9324','Mitchhaven','NC','53195-5506','9202780764','2857329681','armando.kutch@company.net',323,101,404,202,@UpdateUserId,@UpdateTs),
(5,'343-55-5326','Rogelio','PhD','Ortiz','2001-09-01','F','2001-01-11',NULL,253.14676,'0208 Halvorson Locks','84159','Schusterchester','FL','13998','9332318336','7049510207','johnson.oconnell@company.net',317,107,403,202,@UpdateUserId,@UpdateTs),
(6,'066-77-9742','Jean','V','Thiel','2000-12-02','M','2012-03-03','2023-08-14',582.44836,'63430 Lavonda Village','518','South Bernitaburgh','LA','49063-5411','7597675967','5931370395','leonel.sporer@company.net',304,101,401,201,@UpdateUserId,@UpdateTs),
(7,'001-20-0891','Marlo','II','Ledner','1960-12-20','M','1997-06-12',NULL,125.05063,'575 Altagracia Locks','400','North Derrick','ID','16487','8468715233','0749710687','kimi.mann@company.net',301,104,401,202,@UpdateUserId,@UpdateTs),
(8,'637-89-5380','Melony','V','Okuneva','1977-04-29','M','2010-09-26','2023-08-06',474.31363,'27988 Judson Throughway','31807','South Dora','UT','50544','9546918039','8451512954','adan.wehner@company.net',325,105,405,201,@UpdateUserId,@UpdateTs),
(9,'030-87-6166','Gretchen','II','Kunze','1964-03-07','F','1995-06-02',NULL,1543.1498,'236 Deonna Meadow','5601','New Garry','ID','16997','4728625505','1248145310','rolande.brown@company.net',320,106,403,201,@UpdateUserId,@UpdateTs),
(10,'049-37-5665','Ilse','DVM','Tremblay','1996-09-06','M','2002-03-07',NULL,1376.7504,'9194 Arletha Alley','13409','Koeppland','OR','26538','2471399585','4878657464','garfield.strosin@company.net',306,109,403,201,@UpdateUserId,@UpdateTs),
(11,'893-12-0310','Lise','DVM','Dickens','1993-02-28','F','2010-09-11','2023-09-02',675.9771,'424 Jimmie Forest','853','Ritatown','ND','88036','7441277922','6015937097','danny.bergnaum@company.net',318,103,406,202,@UpdateUserId,@UpdateTs),
(12,'141-70-0943','Lorean','II','Grady','1973-03-22','F','2015-04-06',NULL,1233.6118,'74888 Frami Canyon','65027','Darryltown','WY','51100-6873','9720232906','1508272732','vanna.gottlieb@company.net',301,105,402,202,@UpdateUserId,@UpdateTs),
(13,'844-40-3478','Vince','III','Johnston','1970-10-05','M','2005-10-26','2023-08-17',1674.5076,'754 Frankie Viaduct','601','Port Lorrettamouth','WI','91222-9743','1622136538','8860131455','mack.bartoletti@company.net',305,104,406,201,@UpdateUserId,@UpdateTs),
(14,'223-97-5655','Lachelle','Sr.','Padberg','1970-10-27','F','2018-01-06','2023-08-20',677.43884,'35565 Elvis Ridges','23423','New Nildafurt','VA','67033-3172','2101649056','9450840676','elba.haag@company.net',318,105,404,201,@UpdateUserId,@UpdateTs),
(15,'123-25-4770','Alden','Jr.','Collins','1976-11-07','M','2010-03-23',NULL,69.106575,'65450 Sha Crossing','310','Hodkiewiczville','AR','53533-4517','5355156959','6895665650','jed.boyle@company.net',303,101,403,202,@UpdateUserId,@UpdateTs),
(16,'605-94-0890','Steve','V','Thiel','1969-12-17','M','2000-03-18','2023-08-24',996.3276,'5934 Mohamed Key','2249','Sudieport','MD','91382-8308','1459798599','7881529125','jonathon.kling@company.net',319,109,404,203,@UpdateUserId,@UpdateTs),
(17,'716-92-5292','Gaston','III','Kuhic','1970-02-22','M','2015-02-18','2023-08-11',1195.9048,'8108 Greenholt Turnpike','062','East Epifaniaview','MD','61191-4353','0180757878','0078434883','milford.fadel@company.net',316,108,406,203,@UpdateUserId,@UpdateTs),
(18,'425-32-2372','Horacio','III','Treutel','2002-10-21','F','2006-02-19','2023-08-14',439.05954,'9067 Reid Lake','3689','Lake Renetta','ND','48121-3920','9022362354','9642821397','janean.wunsch@company.net',303,103,404,203,@UpdateUserId,@UpdateTs),
(19,'116-26-5837','Lore','Sr.','Barton','1977-07-27','M','1998-03-31',NULL,1318.5895,'865 Rosemarie Point','67435','Jessikamouth','MI','33389','9450404865','2149363239','glynis.rempel@company.net',309,105,402,202,@UpdateUserId,@UpdateTs),
(20,'799-96-6446','Alesha','V','Jakubowski','1996-04-09','F','2016-02-21','2023-08-09',183.11192,'13956 Emmett Vista','018','Leschstad','TN','37586-4577','5362711282','9911862632','cedrick.west@company.net',305,106,404,201,@UpdateUserId,@UpdateTs),
(21,'225-89-5295','Donnie','DDS','Walker','1982-09-19','F','2020-07-31',NULL,845.84796,'34335 Jacobson Ridges','04847','Kleinberg','WV','62999-9824','8002670120','8800507180','monica.kovacek@company.net',314,101,401,202,@UpdateUserId,@UpdateTs),
(22,'004-96-2467','Carey','DDS','Schultz','1970-03-28','M','2013-11-14',NULL,1660.4083,'27016 Johnette Plaza','1306','Joesphbury','KY','38035','3788196882','8825358334','sammie.west@company.net',321,107,405,201,@UpdateUserId,@UpdateTs),
(23,'849-55-0340','Santos','Sr.','Jerde','1964-01-08','F','2013-12-31',NULL,1466.9546,'5506 Brandy Brooks','5094','Langoshstad','ID','42459','5664629478','6876968604','horacio.braun@company.net',320,101,403,201,@UpdateUserId,@UpdateTs),
(24,'765-15-7707','Jerome','IV','Bode','1998-11-28','F','2023-06-04',NULL,1695.9246,'43725 Ortiz Ranch','4143','Donnellyhaven','NM','17688-6081','4393425606','2330271667','gale.pacocha@company.net',312,102,406,202,@UpdateUserId,@UpdateTs),
(25,'551-69-2040','Cary','II','Oberbrunner','1976-05-26','F','2009-09-07',NULL,901.2363,'86906 Yong Crescent','960','New Marquetta','CA','53082-7618','2474525825','4419817284','blanch.osinski@company.net',307,104,405,201,@UpdateUserId,@UpdateTs),
(26,'887-37-9691','Truman','MD','Rowe','2005-04-01','M','2008-06-27','2023-08-15',487.51288,'17869 Ziemann Centers','86632','Boscofurt','OH','81516','1147132516','5189912263','humberto.hayes@company.net',306,106,402,203,@UpdateUserId,@UpdateTs),
(27,'407-48-1433','Deedra','II','Kris','1960-01-16','F','2010-06-16','2023-08-22',101.40831,'60884 Emmanuel Light','06776','Zacharyborough','MN','26464-5748','9457648436','7536330171','lisa.breitenberg@company.net',314,103,406,203,@UpdateUserId,@UpdateTs),
(28,'393-19-1560','Golden','III','Johnston','1966-08-10','M','2023-03-16',NULL,1679.5569,'4949 Boyer Run','7845','South Richardborough','NV','89021','6987607108','8225229678','cammie.waelchi@company.net',310,108,404,201,@UpdateUserId,@UpdateTs),
(29,'806-62-9752','Crysta','MD','Labadie','1975-02-18','M','2006-10-16','2023-08-30',773.0148,'367 Fadel Gateway','05455','North Armandoview','AZ','40009-7290','2411387305','1899951479','adrian.leannon@company.net',320,106,401,202,@UpdateUserId,@UpdateTs),
(30,'524-58-9805','Lindy','DVM','Barton','1975-10-14','F','2009-09-13',NULL,397.3216,'42335 Zachariah Heights','0627','Carlfort','MO','20334','3941986696','3908332237','beula.flatley@company.net',314,105,406,202,@UpdateUserId,@UpdateTs),
(31,'207-41-6968','Soo','Jr.','Gerlach','1977-07-01','M','1999-03-27','2023-09-03',684.46606,'93867 Sigrid Pike','2185','Lebsackville','ME','88556','2100146550','8726028520','isa.mcglynn@company.net',302,104,404,202,@UpdateUserId,@UpdateTs),
(32,'724-50-5751','Bryon','PhD','Padberg','1994-12-30','M','2008-02-25',NULL,939.1116,'66792 Valentine Shoal','94893','Zulauffort','GA','80801-2280','0551570843','8635518730','adrien.konopelski@company.net',314,104,403,201,@UpdateUserId,@UpdateTs),
(33,'231-32-7796','Efren','IV','Nicolas','1982-12-03','M','2004-05-01',NULL,1059.4083,'825 Harris Port','6583','Eddiechester','UT','30499-4504','4751996485','2948812249','lamar.toy@company.net',315,109,401,203,@UpdateUserId,@UpdateTs),
(34,'726-62-0175','Jacklyn','PhD','Koepp','1974-03-24','F','2000-03-05','2023-08-20',753.5995,'7844 Bayer Knolls','58968','North Agathamouth','WI','16932-8056','9426347533','2232508133','pat.cartwright@company.net',302,101,403,201,@UpdateUserId,@UpdateTs),
(35,'438-27-6810','Caitlyn','MD','Anderson','1988-12-24','F','2008-07-21',NULL,1586.4152,'2146 Clarence Spurs','96073','North Princess','MT','40718','8098144204','8255562722','hayden.conn@company.net',320,105,403,202,@UpdateUserId,@UpdateTs),
(36,'728-27-4437','Jarod','I','Prosacco','1964-03-13','F','2008-03-24','2023-08-23',791.94006,'89541 Earle Ports','440','Jacksonchester','MT','25499-5098','2898847229','2641499957','nerissa.schumm@company.net',301,108,401,201,@UpdateUserId,@UpdateTs),
(37,'295-06-7283','Sam','V','Koepp','1982-01-23','M','2018-05-22','2023-09-01',1026.2391,'58323 Funk Ways','96943','Prosaccoland','IN','37901','5815566615','4219350182','edwin.ondricka@company.net',310,108,402,203,@UpdateUserId,@UpdateTs),
(38,'584-16-4422','Coralie','DVM','Sanford','1964-02-26','F','2013-04-14',NULL,1191.5311,'5230 Augustine Square','34605','Cleliamouth','NH','67647','0939259103','6482187346','hershel.olson@company.net',316,109,401,202,@UpdateUserId,@UpdateTs),
(39,'859-59-8110','Marx','II','Dibbert','1989-06-13','F','2016-04-16',NULL,1372.1107,'43834 Gusikowski Ramp','6277','New Burlville','KY','33072-6107','4616158462','9534647736','alia.cassin@company.net',310,107,401,203,@UpdateUserId,@UpdateTs),
(40,'840-28-8863','Xochitl','MD','Jenkins','1987-04-16','M','2001-10-31',NULL,392.5361,'1673 McLaughlin Viaduct','3937','Emmanuelchester','MD','71093-5306','6113315794','7355993426','bertram.littel@company.net',302,107,401,201,@UpdateUserId,@UpdateTs),
(41,'714-38-9392','Oscar','II','Treutel','1977-01-19','M','2006-08-02','2023-08-19',1959.8251,'9388 Parisian Place','18172','Port Kyra','HI','53769-3268','8842356648','4235218372','harlan.kerluke@company.net',314,107,402,202,@UpdateUserId,@UpdateTs),
(42,'548-09-8673','Lavette','III','Schimmel','1966-10-08','M','2001-11-10',NULL,1683.5306,'0093 Hudson Circle','037','Port Lesley','CA','04181','7257255360','8391279248','lashon.jaskolski@company.net',317,109,403,202,@UpdateUserId,@UpdateTs),
(43,'102-45-7265','Ralph','DVM','Kiehn','1985-04-28','M','1995-04-30',NULL,364.60236,'6579 Dietrich Divide','40265','East Travisville','FL','83036-5458','0869531316','3771619773','dwight.lockman@company.net',309,103,404,202,@UpdateUserId,@UpdateTs),
(44,'287-90-8180','Carmen','V','Huels','1989-12-08','F','2020-11-21','2023-08-05',1681.8867,'88891 Sherman Avenue','7422','East Ouida','SD','66930-0211','5712646762','5955966870','marybeth.miller@company.net',315,108,405,203,@UpdateUserId,@UpdateTs),
(45,'657-66-3631','Haywood','V','Hudson','2003-05-26','M','2001-11-01',NULL,180.96118,'303 Steuber Cape','55155','South Ikeland','WY','43939','6591146196','6902934236','waldo.armstrong@company.net',315,101,405,202,@UpdateUserId,@UpdateTs),
(46,'197-71-5200','Rodrigo','PhD','Cassin','1997-02-11','M','2003-03-05','2023-08-19',778.7584,'04534 Russel Common','722','Hagenesbury','VA','49829-6593','8441700238','7499798680','eve.stiedemann@company.net',321,103,404,201,@UpdateUserId,@UpdateTs),
(47,'555-87-6172','Randy','III','Wolf','2003-10-01','F','2005-11-01','2023-08-25',1048.0941,'3607 Goyette Shoals','1759','South Pablo','OK','08770','3718082165','3069034041','nelson.gutkowski@company.net',310,102,404,203,@UpdateUserId,@UpdateTs),
(48,'294-18-2918','Shantell','IV','Kessler','1960-04-25','F','2014-02-12',NULL,150.78052,'518 Marlon Village','444','Tillmanville','NM','87656','9983118025','3714775934','francisco.langworth@company.net',310,101,401,201,@UpdateUserId,@UpdateTs),
(49,'794-46-6613','Sterling','DDS','Streich','1984-10-25','M','2008-01-26','2023-08-14',511.48175,'256 Stracke Highway','4723','New Weston','TN','84812-6132','4425038591','5061904822','lesley.mitchell@company.net',310,107,402,201,@UpdateUserId,@UpdateTs),
(50,'021-89-7844','Reid','Sr.','Marks','2002-12-29','M','1999-08-22',NULL,1279.8458,'52476 Mertz Summit','659','Keeblerbury','NY','46442','3032534267','6678522193','neva.daugherty@company.net',301,108,404,202,@UpdateUserId,@UpdateTs),
(51,'663-72-6081','Darrel','Jr.','Reilly','1975-03-21','F','2013-04-15','2023-08-05',1699.7355,'54968 Michal Village','38649','Hyattshire','MT','38812','0117705714','9878066602','cecile.gislason@company.net',304,108,405,203,@UpdateUserId,@UpdateTs),
(52,'323-67-2663','Jean','Jr.','Dooley','1973-06-18','M','2003-02-11','2023-08-11',1004.5724,'814 Muller Hill','639','Eladiafort','MA','85611','8437123075','0310340651','elin.abernathy@company.net',319,109,402,202,@UpdateUserId,@UpdateTs),
(53,'503-49-9149','Rodney','PhD','Stracke','1994-09-04','M','2001-10-27',NULL,1772.9059,'263 Hackett Groves','976','Adanborough','NC','36591','0483515114','7287367883','larhonda.lemke@company.net',304,107,405,201,@UpdateUserId,@UpdateTs),
(54,'611-86-3203','Mitch','II','Spencer','1970-07-10','M','2007-05-20','2023-08-25',230.32542,'317 Teodoro Flat','218','East Tamar','FL','49739-7177','3543551097','2656528990','phillip.haag@company.net',309,102,403,203,@UpdateUserId,@UpdateTs),
(55,'587-39-7226','Stephan','II','Casper','1962-09-12','F','2016-12-21',NULL,1314.7452,'05201 Marketta Plaza','4239','New Dawnaborough','PA','94250-2590','8384908301','4833689999','loma.moore@company.net',321,102,404,203,@UpdateUserId,@UpdateTs),
(56,'134-01-2880','Linette','I','Klein','1986-09-23','M','1995-08-26',NULL,1718.9059,'03473 Tereasa Common','976','Doyleland','AK','06080-6625','1379367878','8774759825','georgine.boyle@company.net',317,103,403,202,@UpdateUserId,@UpdateTs),
(57,'007-61-0804','Rubin','Jr.','Kunde','1988-01-11','F','2005-12-15',NULL,829.664,'00760 Marlene Hills','6906','North Quinn','OK','60136','8696789925','0273232341','maryln.bins@company.net',310,108,401,201,@UpdateUserId,@UpdateTs),
(58,'125-01-9486','Randell','II','Dickinson','1971-05-25','F','1998-10-31','2023-08-11',916.2698,'645 Tyron Drive','758','Jaskolskiport','HI','17088-4134','3391753075','4555955286','lan.parisian@company.net',315,104,401,202,@UpdateUserId,@UpdateTs),
(59,'142-37-7777','Milan','Jr.','Kerluke','1977-02-28','M','2022-08-16','2023-09-01',951.3665,'2018 Scottie Haven','9256','Port Angeliqueville','NY','68980','1593421045','6088039961','dot.harvey@company.net',309,106,405,203,@UpdateUserId,@UpdateTs),
(60,'368-18-3723','Johnathon','III','Koelpin','1969-06-04','M','1996-12-09',NULL,1176.892,'5871 Dach Row','4240','Franshire','KY','10137','9746403107','5247591114','yuk.kiehn@company.net',302,103,406,201,@UpdateUserId,@UpdateTs),
(61,'733-74-4485','Luis','DDS','Jacobi','1987-07-28','M','2016-09-11','2023-08-17',1864.4073,'5714 Willodean Road','99149','North Melisaville','NH','30278','5659692805','0668031043','jann.mitchell@company.net',305,106,403,202,@UpdateUserId,@UpdateTs),
(62,'486-79-1267','Georgie','MD','Gleason','1993-03-07','M','2021-07-08','2023-08-13',939.63605,'3848 Royce Loaf','05980','Port Nova','WA','25765','1058165755','6646078342','ardelle.leannon@company.net',324,104,405,203,@UpdateUserId,@UpdateTs),
(63,'551-11-6510','Bernard','III','Bednar','1974-06-13','M','2008-11-05','2023-09-01',1432.1545,'43044 O''Hara Manor','3097','Johnstonmouth','TN','81540-8633','3326639711','5983894460','eldon.mertz@company.net',319,106,406,201,@UpdateUserId,@UpdateTs),
(64,'209-01-0123','Rex','MD','West','2004-05-26','F','2005-11-13',NULL,966.2456,'4289 Ruecker Run','061','New Donte','KS','72411','4971531883','7695111847','kevin.dubuque@company.net',304,102,401,203,@UpdateUserId,@UpdateTs),
(65,'163-24-5344','Malvina','DDS','Harvey','1983-06-16','F','2012-07-22',NULL,896.89856,'7761 Celina Lane','972','Port Elvie','TX','73122-5450','3330886038','8531597289','anika.cremin@company.net',307,103,405,202,@UpdateUserId,@UpdateTs),
(66,'869-36-7238','Darlena','Jr.','Schuppe','1984-05-08','M','2007-04-06','2023-08-24',1377.8185,'44471 Samara Locks','62725','Macejkovicfurt','CA','29946-6566','0967935538','1882423523','levi.schinner@company.net',324,109,406,203,@UpdateUserId,@UpdateTs),
(67,'719-03-2782','Ashlyn','IV','Kuvalis','1966-04-18','M','2005-05-01',NULL,504.09607,'4667 Wallace Springs','03466','Port Masonborough','KY','42924-2597','3318375077','4345576675','alton.sauer@company.net',325,105,404,202,@UpdateUserId,@UpdateTs),
(68,'023-05-8642','Jerald','PhD','Kirlin','1992-04-25','F','2014-02-11','2023-08-29',549.87866,'237 Rutherford Walk','628','Sherleneside','HI','08534','9923203166','6849446988','antoine.reinger@company.net',313,108,401,203,@UpdateUserId,@UpdateTs),
(69,'698-41-5121','Krissy','IV','Streich','1964-09-21','F','1996-11-08','2023-08-27',1642.985,'25318 Morgan Ranch','578','Friesenport','CT','69335','2828231956','3739540116','loren.braun@company.net',321,106,403,203,@UpdateUserId,@UpdateTs),
(70,'395-91-8483','Grisel','Jr.','Bosco','1959-07-09','M','2001-09-21','2023-08-14',1530.9076,'49111 Oliver Ridge','35605','East Lennystad','WV','42888','2845099934','6639596155','shonna.tromp@company.net',323,109,406,203,@UpdateUserId,@UpdateTs),
(71,'507-41-3484','Krista','I','Gleason','1979-08-21','M','2001-05-14','2023-08-28',956.06116,'446 Gisele Station','696','North Mitsukoburgh','FL','12245','3907952945','5308976345','noel.schuppe@company.net',309,103,405,201,@UpdateUserId,@UpdateTs),
(72,'863-70-9601','Mel','PhD','Carter','2003-06-25','F','2016-04-23',NULL,232.45,'99877 Kayce Inlet','8085','Maricelafurt','MS','72364','7905152320','2452702155','gerard.shanahan@company.net',305,109,406,203,@UpdateUserId,@UpdateTs),
(73,'635-04-9351','Gregory','Sr.','Kertzmann','1978-08-26','F','2010-12-27',NULL,1448.1534,'59081 Jason Place','4359','Sibylchester','MO','44080-7032','4072251777','4883634284','letitia.hahn@company.net',304,102,401,203,@UpdateUserId,@UpdateTs),
(74,'302-71-6773','Walton','II','King','1974-02-03','M','1994-05-25',NULL,1576.156,'89977 Green Creek','0261','Jeraldshire','IL','02342','2618515688','2092813509','marlon.goodwin@company.net',301,109,401,203,@UpdateUserId,@UpdateTs),
(75,'800-50-5314','Douglas','Sr.','Hilll','2004-06-23','F','2007-07-17',NULL,1255.0864,'35698 Louann Mountain','1006','East Dallasview','MS','31734','0968529090','4586491120','latosha.reinger@company.net',322,109,401,203,@UpdateUserId,@UpdateTs),
(76,'339-79-9384','Elene','II','Murphy','1975-05-04','M','2007-04-13',NULL,19.373001,'168 Federico Field','141','Kevenland','NE','13226-7125','8229958852','5543561845','roderick.bernhard@company.net',320,107,403,201,@UpdateUserId,@UpdateTs),
(77,'056-96-8390','Concha','Jr.','Gibson','1995-01-20','M','2016-08-15','2023-08-05',1040.1678,'45027 Brekke Union','6087','Ziemechester','AZ','71612-7610','5350686949','4476273371','kacie.schaden@company.net',314,104,406,202,@UpdateUserId,@UpdateTs),
(78,'182-93-9079','Lloyd','III','Osinski','1965-05-13','F','2011-03-23',NULL,1425.1521,'745 Hansen Green','760','South Delilatown','KS','31973-0932','4538207062','1367437947','johnathan.kihn@company.net',320,105,406,201,@UpdateUserId,@UpdateTs),
(79,'211-79-7830','Cleo','DVM','Willms','1993-08-30','F','2013-06-11','2023-08-09',77.99102,'02050 Johnson Fort','8669','Annikaburgh','KY','79604-4022','1733789691','4671886369','blair.schmeler@company.net',325,107,406,201,@UpdateUserId,@UpdateTs),
(80,'568-74-1356','Levi','MD','Schimmel','1989-05-31','M','1999-08-20','2023-08-24',1563.7797,'023 Spinka Islands','6900','East Tiffanihaven','CT','23970-0828','5622470292','4302041255','judson.krajcik@company.net',307,109,406,203,@UpdateUserId,@UpdateTs),
(81,'425-18-7330','Izola','II','Cummerata','2000-07-02','F','2012-08-26',NULL,1637.288,'03979 Bartoletti Fall','75055','Cletushaven','IA','03736-3641','2483627309','6299446575','gisele.schulist@company.net',315,107,406,202,@UpdateUserId,@UpdateTs),
(82,'792-38-0320','Delores','IV','Halvorson','1974-03-04','M','2007-01-20','2023-08-17',281.2002,'5764 Torp Trafficway','75381','Jeraldineside','ME','54643-4725','9465460518','6079801253','melani.aufderhar@company.net',318,108,401,202,@UpdateUserId,@UpdateTs),
(83,'759-18-9333','Andrew','Sr.','Farrell','1959-10-27','F','2005-04-20',NULL,66.824066,'709 Skiles Drive','48857','East Pandora','MN','07056','1915309817','8404848293','bob.price@company.net',311,102,406,202,@UpdateUserId,@UpdateTs),
(84,'315-91-9872','Jacque','IV','Steuber','1991-03-19','F','2007-11-30','2023-08-12',211.94174,'4560 Schimmel Dale','632','Ankundingmouth','MA','02060','9381515433','7158836846','wendie.schimmel@company.net',309,103,405,202,@UpdateUserId,@UpdateTs),
(85,'193-63-7170','Kelly','DDS','Baumbach','1988-04-04','M','1998-08-03',NULL,460.5706,'10174 Marla Station','314','Owenfort','HI','47163','8711432704','3651698521','jaqueline.hane@company.net',309,107,402,202,@UpdateUserId,@UpdateTs),
(86,'490-31-7043','Lonny','I','Schaefer','1984-01-30','F','2019-04-24',NULL,1346.4078,'960 Wisoky Station','317','South Jamika','MT','02644','9517423333','3061208544','nelson.schowalter@company.net',314,104,406,202,@UpdateUserId,@UpdateTs),
(87,'522-60-9244','Sue','DDS','Murray','1963-12-07','F','2008-09-19',NULL,1483.6444,'992 McDermott Divide','023','South Elisabeth','NJ','90899','3901388921','9462171309','emmie.mcglynn@company.net',304,104,405,202,@UpdateUserId,@UpdateTs),
(88,'423-95-6738','Danae','III','Langosh','1987-01-17','F','2015-03-04','2023-08-16',1823.6495,'839 Mignon Ports','04803','Clarenceport','AK','22538','4080967694','5164300379','sherron.becker@company.net',323,103,403,203,@UpdateUserId,@UpdateTs),
(89,'169-77-3498','Clifford','DDS','Abshire','1988-05-06','M','1999-06-05','2023-08-18',1384.7529,'8118 Wyman Estate','3608','South Tinishastad','NM','37506-1437','0186103588','4236547240','herta.carter@company.net',325,105,405,203,@UpdateUserId,@UpdateTs),
(90,'833-25-1143','Tu','V','Fritsch','1986-12-10','F','2005-01-17',NULL,1954.9802,'236 Retta Highway','827','Winonatown','AL','97883-8475','3646513034','3174638696','devon.feil@company.net',308,106,401,203,@UpdateUserId,@UpdateTs),
(91,'367-96-7698','Titus','I','Miller','1984-03-29','M','2021-09-15',NULL,1083.1324,'590 Oliver Rapid','5924','Danniestad','VA','56050','8553043051','0342926781','taylor.koepp@company.net',322,101,401,201,@UpdateUserId,@UpdateTs),
(92,'577-03-7456','Barney','V','Fisher','1997-03-07','M','1995-05-22','2023-08-18',259.04678,'16773 Deandrea Heights','779','Champlinland','MD','56063','9967255424','9323049913','brant.king@company.net',324,109,404,201,@UpdateUserId,@UpdateTs),
(93,'223-32-2287','Maria','Sr.','Toy','1975-12-24','M','2015-01-02',NULL,1037.2179,'0690 Dominick Brooks','042','Jospehmouth','AZ','53847-5934','7494742512','0838640995','deanne.jerde@company.net',309,107,404,201,@UpdateUserId,@UpdateTs),
(94,'132-69-7804','Spencer','I','Gibson','1985-12-15','M','1993-12-08',NULL,828.22107,'88903 Jerde Freeway','56359','Smithamfort','MN','44946-3079','7234192282','8836848753','britney.kutch@company.net',304,102,404,203,@UpdateUserId,@UpdateTs),
(95,'660-06-2775','Herbert','III','Goldner','1973-11-06','F','2009-05-24','2023-08-15',886.5336,'241 Kunze Vista','438','North Misha','MI','66996','4448949310','0979787743','prince.beahan@company.net',308,102,401,201,@UpdateUserId,@UpdateTs),
(96,'207-82-2556','Traci','MD','Weimann','1967-04-24','F','1995-09-19','2023-08-21',1876.4232,'374 Kizzie Squares','296','Stantonhaven','MT','41139','1456591847','8463649828','carlton.brown@company.net',320,108,405,203,@UpdateUserId,@UpdateTs),
(97,'447-95-1810','Tammi','Jr.','Purdy','1992-05-28','M','1998-02-19',NULL,1455.5411,'0908 Stoltenberg Lane','041','New Valrieside','NV','57233-3961','5080703905','9312897989','leann.rippin@company.net',303,104,402,203,@UpdateUserId,@UpdateTs),
(98,'390-27-6769','Casey','PhD','Stamm','1979-08-27','M','2015-04-18','2023-08-31',1252.742,'473 Cory Port','48887','North Narcisamouth','TN','76800-7263','1591034825','8809937370','wally.jakubowski@company.net',306,106,405,201,@UpdateUserId,@UpdateTs),
(99,'899-72-3599','Evon','II','Hudson','1999-10-29','M','2006-06-06',NULL,417.4346,'7547 Kshlerin Port','946','West Margarete','MT','22440-6549','1471258550','0690693457','calandra.kuhn@company.net',317,104,406,201,@UpdateUserId,@UpdateTs),
(100,'493-55-5943','Edmond','PhD','Rath','1993-12-11','F','1996-12-26','2023-08-04',1637.4641,'4316 Balistreri Isle','810','Schuppeburgh','CO','94045-4421','2013268092','7829197324','zella.leannon@company.net',302,101,401,203,@UpdateUserId,@UpdateTs),
(101,'869-63-6972','Myrtice','V','Corwin','1983-05-02','M','2001-07-22',NULL,419.12045,'023 Hartmann Coves','743','Wolfshire','IN','88478-6135','8031313537','6102202192','bennie.steuber@company.net',319,102,404,203,@UpdateUserId,@UpdateTs),
(102,'063-28-4771','Ola','PhD','Rohan','1994-11-25','F','1997-12-02',NULL,1711.377,'7635 Nick Mall','0906','Kuvalisborough','AL','23363-6183','7974081276','4366543467','william.gulgowski@company.net',318,107,406,203,@UpdateUserId,@UpdateTs),
(103,'243-13-5878','Annett','Sr.','Osinski','1963-10-09','F','2020-09-11',NULL,703.87067,'414 Weimann River','87109','Port Marvisberg','KY','27189','7420131633','7684580123','isidro.mann@company.net',324,109,403,201,@UpdateUserId,@UpdateTs),
(104,'061-94-2692','Lessie','DVM','Ruecker','1980-11-03','M','2017-01-16',NULL,1162.4564,'31337 Yost Island','390','Pamellaburgh','AR','84398','6298329317','8226111177','ricki.reinger@company.net',324,105,404,201,@UpdateUserId,@UpdateTs),
(105,'218-02-0360','Royce','MD','Adams','1975-04-12','M','2017-12-23','2023-08-23',1404.3871,'4990 Gottlieb Islands','2017','Donteport','NY','20928-6163','2473771778','5706564575','wallace.schoen@company.net',321,106,406,203,@UpdateUserId,@UpdateTs),
(106,'817-55-7540','Yesenia','V','Cummings','1980-06-17','M','2004-05-17','2023-08-06',1152.3053,'224 Bartoletti Pine','30344','North Dayna','HI','24317','4484753536','4899703481','li.ortiz@company.net',303,106,403,201,@UpdateUserId,@UpdateTs),
(107,'046-52-2703','Roderick','DDS','Gutkowski','1983-04-25','M','2006-03-04','2023-08-26',228.26587,'923 Karon Forks','096','Port Marquis','MN','64414-0705','1830714576','5485553774','claretta.doyle@company.net',314,101,401,201,@UpdateUserId,@UpdateTs),
(108,'172-60-4455','Earnest','V','Dicki','1987-04-01','M','2019-09-08','2023-08-25',296.95273,'8438 Mante Points','890','West Erin','MO','49970','9191823555','6157287571','tom.jaskolski@company.net',313,108,402,202,@UpdateUserId,@UpdateTs),
(109,'484-76-2534','Danika','DDS','Douglas','1981-05-26','M','2004-04-24','2023-08-19',862.09937,'4263 Nathanial River','59110','Lake Bevhaven','KS','98909','0040304570','9420255410','delsie.grant@company.net',317,107,402,202,@UpdateUserId,@UpdateTs),
(110,'680-14-7403','Stephen','DVM','Swift','2001-05-12','F','2006-03-15',NULL,1483.8811,'757 Nicky Canyon','79591','Hansenmouth','LA','04612','5198134671','9038855588','della.morissette@company.net',310,101,406,202,@UpdateUserId,@UpdateTs),
(111,'713-01-7570','Brice','MD','Kiehn','1974-09-02','F','2022-03-06',NULL,52.704876,'486 Elvie Walks','74301','New Careyshire','TX','56132-2815','0910496896','0912416378','lucina.kohler@company.net',318,107,405,202,@UpdateUserId,@UpdateTs),
(112,'506-30-1127','Nelia','Jr.','Hermann','1993-11-24','M','2003-05-27','2023-08-06',706.39124,'65667 Schiller Overpass','507','North Mariellatown','AL','15162-5670','3478553965','9383247238','noah.oconnell@company.net',313,106,401,202,@UpdateUserId,@UpdateTs),
(113,'207-55-1988','Hunter','Sr.','Strosin','1993-03-22','F','2023-08-31',NULL,1118.2177,'480 Schimmel Pass','32354','South Cyndi','NE','42183','8643809330','5258285966','kayce.herzog@company.net',321,103,405,203,@UpdateUserId,@UpdateTs),
(114,'512-59-3403','Jackelyn','DDS','Feil','1979-03-25','M','2001-12-30',NULL,452.6699,'379 Luisa Stravenue','82064','West Guadalupe','KS','25266','6546078330','2974437417','jamal.rath@company.net',317,101,401,202,@UpdateUserId,@UpdateTs),
(115,'443-67-5647','Vernon','DVM','Hansen','2002-07-02','M','2001-12-27','2023-08-17',884.03674,'50053 Barbera Key','148','Heidyside','WI','21433','1593321625','9717148074','brigitte.altenwerth@company.net',320,109,405,203,@UpdateUserId,@UpdateTs),
(116,'160-23-2861','Carol','V','O''Conner','1966-05-11','M','2017-05-26','2023-08-20',1372.1737,'5831 Hane Light','0232','Dannport','KS','27487-5148','0716559097','3412779451','trudi.hermiston@company.net',315,107,406,203,@UpdateUserId,@UpdateTs),
(117,'780-54-3303','Ryann','DVM','Frami','1965-08-18','M','2012-10-24','2023-08-24',942.86206,'94856 Kling Point','444','Port Lane','MD','16732','1770391310','9099859551','star.abbott@company.net',302,108,406,201,@UpdateUserId,@UpdateTs),
(118,'548-26-0321','Vito','DVM','Jast','1963-05-17','M','2000-06-26','2023-08-16',240.19168,'428 Vanesa Track','22053','Jacobsville','DE','85305-4923','6191383496','7017193082','wilber.dickinson@company.net',307,106,402,201,@UpdateUserId,@UpdateTs),
(119,'643-60-3449','Brandon','Sr.','Stroman','1980-02-29','F','2006-01-18','2023-08-21',967.31085,'34017 Hammes Underpass','9094','New Germanstad','MO','83447-2179','8682291121','6465296721','sherwood.kub@company.net',304,109,402,201,@UpdateUserId,@UpdateTs),
(120,'758-86-3751','Olga','Jr.','D''Amore','1959-07-19','M','2003-06-01',NULL,570.6999,'2695 Kunze Gardens','427','North Fannyfurt','NY','02286-3686','2703981586','6530173171','ronald.kuhic@company.net',324,103,401,202,@UpdateUserId,@UpdateTs),
(121,'280-84-8900','Raymonde','I','Kemmer','1996-08-19','M','1995-04-23',NULL,1636.8518,'908 Kuhn Pass','298','Rickeyburgh','ND','81759-8050','5087739479','3954048685','otha.trantow@company.net',318,105,405,202,@UpdateUserId,@UpdateTs),
(122,'719-45-8404','Cyril','III','Botsford','2000-02-07','F','2016-07-29',NULL,898.87213,'580 Schiller Islands','25817','Elizebethside','VT','40214-0208','2698717045','3075892358','charlott.mckenzie@company.net',301,107,402,202,@UpdateUserId,@UpdateTs),
(123,'454-86-0757','Linnea','IV','Gislason','1966-02-07','M','2006-07-28',NULL,625.0452,'43642 Mervin Estates','205','New Lillianatown','FL','37464','2543019186','8619466539','troy.wuckert@company.net',317,104,406,202,@UpdateUserId,@UpdateTs),
(124,'824-61-2632','Elijah','I','Daniel','2003-04-29','F','2001-01-02','2023-08-21',449.8591,'02162 Kessler Inlet','0240','Lake Nicolleshire','ND','23308-1148','5389986276','6247230650','mitchel.gaylord@company.net',315,107,401,203,@UpdateUserId,@UpdateTs),
(125,'673-01-2139','Samuel','II','Wehner','1967-11-05','F','2017-06-24','2023-08-29',1364.3269,'39396 Sang Club','87446','Port Jacquelyne','ME','35999','7798122165','9422616316','wilda.zemlak@company.net',310,109,402,202,@UpdateUserId,@UpdateTs),
(126,'703-19-4552','Ronda','DDS','Cummerata','2000-06-30','F','2002-01-07','2023-08-10',1502.6998,'1776 Dicki Glen','3023','Georgechester','NJ','87921-0799','4032155571','6849261520','denese.pfeffer@company.net',303,108,401,201,@UpdateUserId,@UpdateTs),
(127,'835-19-4272','Anissa','IV','Rosenbaum','1972-10-06','F','2008-11-18','2023-08-19',566.826,'0486 Crystal Lodge','3358','New Christianeside','SD','27885-2900','6076032782','3987624008','magnolia.gaylord@company.net',321,102,405,202,@UpdateUserId,@UpdateTs),
(128,'416-46-6497','Al','IV','Kuhic','1971-12-02','F','2020-05-07',NULL,1636.4789,'523 Will Flat','01784','Angeleschester','MT','37613','3221693516','5830636817','randy.bernhard@company.net',324,107,403,202,@UpdateUserId,@UpdateTs),
(129,'364-78-5395','Kyung','DDS','Lehner','1985-06-18','F','2005-06-24','2023-08-15',1120.9514,'9651 Hank Mission','21949','New Bridgettefurt','MN','80253','6927081914','3902588101','lorette.thiel@company.net',303,103,405,202,@UpdateUserId,@UpdateTs),
(130,'615-79-0417','Joey','DDS','Ziemann','1961-08-30','F','2022-09-18','2023-08-07',1449.0913,'070 Glover Greens','9895','Jerdemouth','CA','89076-3599','4594910920','6188160869','martina.corwin@company.net',302,106,403,201,@UpdateUserId,@UpdateTs),
(131,'816-45-8428','Emile','Sr.','Hamill','2000-06-08','M','2009-01-18','2023-08-27',843.73987,'3987 Goyette Junction','6713','Ullrichfurt','MO','85666-8309','6447937321','4239408648','jarred.parisian@company.net',303,101,404,203,@UpdateUserId,@UpdateTs),
(132,'329-35-9168','Darrell','I','Lockman','1959-06-21','F','2015-01-09',NULL,199.23067,'08915 Celestina Fall','21821','Angelikaton','MD','03339-7745','4678244980','9029106068','lauren.rosenbaum@company.net',319,105,402,201,@UpdateUserId,@UpdateTs),
(133,'230-61-5469','Eusebio','II','Turner','1972-02-15','M','2010-03-08','2023-08-09',254.199,'8778 Hansen Manors','41245','New Stantonmouth','IA','40320-3820','4499985310','4184336440','keesha.paucek@company.net',316,104,403,201,@UpdateUserId,@UpdateTs),
(134,'311-11-6056','Julio','III','Rowe','1960-05-11','M','2023-04-02','2023-08-22',54.46198,'1330 Feil Knoll','440','East Debbyburgh','AZ','49484-7729','4819883176','8103162074','deshawn.ledner@company.net',313,103,405,201,@UpdateUserId,@UpdateTs),
(135,'527-58-5764','Kyong','Jr.','Schumm','1998-07-19','F','1995-06-27',NULL,35.13801,'3814 Waters Crest','74227','Bayerport','ID','05082-5796','4336371863','8656007736','dallas.emmerich@company.net',306,103,405,202,@UpdateUserId,@UpdateTs),
(136,'767-02-4139','Gary','I','McLaughlin','1981-08-27','F','1998-11-01',NULL,286.49265,'85299 Torp Trail','6030','Mistietown','MA','88166-3206','2313432398','8606348386','elmo.kuphal@company.net',318,108,403,203,@UpdateUserId,@UpdateTs),
(137,'615-43-1596','Simona','V','Bogisich','1989-09-04','F','2022-10-10','2023-08-24',1842.2208,'4282 Rodriguez Neck','4964','O''Keefemouth','ND','99542-5318','8875724716','9528955686','lisbeth.dickens@company.net',305,104,401,202,@UpdateUserId,@UpdateTs),
(138,'090-88-3639','Noel','III','Cummerata','2000-05-02','F','2021-10-29',NULL,170.0059,'87125 Stroman Highway','5911','Emmiefurt','VT','59182','5270598000','0008010896','nicolas.beer@company.net',306,102,402,203,@UpdateUserId,@UpdateTs),
(139,'109-99-1075','Lamar','I','Klein','1982-11-10','F','2000-01-13',NULL,1922.2323,'42439 Blick Harbor','4760','Port Quyenburgh','AZ','42549','9787700288','2716288584','jim.metz@company.net',314,107,401,203,@UpdateUserId,@UpdateTs),
(140,'201-75-7083','Dexter','V','Ziemann','1983-02-16','M','1997-08-29','2023-08-22',766.6692,'693 Blick Centers','09175','South Andremouth','SC','73505','1396182545','4044948106','monnie.oconner@company.net',304,108,401,203,@UpdateUserId,@UpdateTs),
(141,'828-87-2630','Shin','PhD','Beer','1986-10-01','F','2011-04-28',NULL,446.7947,'220 Borer Villages','8088','West Reyna','MN','28381','5584344157','8692925000','sammie.torphy@company.net',324,101,401,201,@UpdateUserId,@UpdateTs),
(142,'267-68-7598','Tresa','Jr.','Rowe','1998-03-03','M','1993-10-18',NULL,230.1807,'70002 Kuphal Forge','43937','Doylebury','UT','17334-5714','3539852545','8447700471','ellis.johnson@company.net',316,101,402,202,@UpdateUserId,@UpdateTs),
(143,'899-74-3231','Ileen','II','Schowalter','2002-10-18','F','2016-03-15',NULL,733.02313,'09098 Monahan Fort','09291','Mayerstad','SC','83841','0557093886','6149877965','marquis.rogahn@company.net',313,101,404,201,@UpdateUserId,@UpdateTs),
(144,'132-47-6177','Donnell','DVM','Murazik','1971-12-06','M','1997-03-15',NULL,602.4679,'4125 Rodger Row','6912','South Greg','IL','58868-8608','3015445463','1858775305','aron.steuber@company.net',316,107,406,201,@UpdateUserId,@UpdateTs),
(145,'820-74-1332','Gisela','III','Medhurst','1976-11-17','F','1998-09-15',NULL,88.85731,'5884 MacGyver Points','207','Konopelskiview','MI','51218-5497','5015713062','2167990937','kennith.oconnell@company.net',301,107,403,202,@UpdateUserId,@UpdateTs),
(146,'714-72-9573','Landon','III','Schoen','1967-02-26','M','2009-10-19',NULL,434.40067,'9280 Grant Rue','75359','Port Chance','MS','56619','5974107913','5136632060','kristopher.crona@company.net',324,107,401,203,@UpdateUserId,@UpdateTs),
(147,'649-48-5118','Sherry','Sr.','Kuvalis','1959-05-18','M','2007-05-01',NULL,343.0599,'41451 Shayne Island','5498','Robelchester','OR','56735-3987','0375720565','1312307288','ernesto.cummings@company.net',320,103,406,201,@UpdateUserId,@UpdateTs),
(148,'485-54-4375','Quincy','DDS','Nienow','1971-03-30','M','1998-06-18',NULL,1174.6332,'4240 Moon Greens','279','Antonyview','PA','50076-0152','9145903415','4170825597','robert.kirlin@company.net',321,105,402,203,@UpdateUserId,@UpdateTs),
(149,'500-63-2167','Markus','Sr.','Flatley','2005-07-24','M','2014-04-24',NULL,595.1173,'03308 Alfredo Islands','41344','North Kelsiestad','KY','52524','5995239747','3874859092','dennis.dooley@company.net',323,104,404,202,@UpdateUserId,@UpdateTs),
(150,'656-93-2502','Kayce','V','Wisoky','1975-09-09','F','1995-08-18','2023-08-05',1936.4365,'347 Hauck Freeway','205','Hoegerchester','MI','88843-9885','3875143621','0113967775','sydney.blanda@company.net',307,106,405,203,@UpdateUserId,@UpdateTs);