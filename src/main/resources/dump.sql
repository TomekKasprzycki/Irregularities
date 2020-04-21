# Role
insert into role (id, name, description) values (1, "ROLE_CREATOR","osoba tworząca zgłoszenia");
insert into role (id, name, description) values (2, "ROLE_MANAGER","osoba weryfikująca zgłoszenia");
insert into role (id, name, description) values (3, "ROLE_OBSERVER","osoba przeglądająca zgłoszenia");
insert into role (id, name, description) values (4, "ROLE_ADMIN","Admin");
insert into role (id, name, description) values (5, "ROLE_WAITING","Osoba czekająca na autoryzację");
# Instytucje
insert into institution (id, name) values (1, "Urząd Marszałkowski Województwa Małopolskiego (ZPO)");
insert into institution (id, name) values (2, "Urząd Marszałkowski Województwa Małopolskiego (FE)");
insert into institution (id, name) values (3, "Urząd Marszałkowski Województwa Małopolskiego (BC)");
insert into institution (id, name) values (4, "Wojewódzki Urząd Pracy w Krakowie");
insert into institution (id, name) values (5, "Małopolskie Centrum Przedsiębiorczości");
insert into institution (id, name) values (6, "Stowarzyszenie Metropolia Krakowska (ZIT)");
# Beneficjenci
insert into beneficiary (id, name, nip) values (1,"Firma doradcza","5360080794");
insert into beneficiary (id, name, nip) values (2,"Gmina Skawina","3554681400");
insert into beneficiary (id, name, nip) values (3,"Województwo Małopolskie","5687744371");
# Projekty
insert into project (id, project_number, beneficiary_id) values (1,"RPMP.01.02.03-12-0012/16",1);
insert into project (id, project_number, beneficiary_id) values (2,"RPMP.03.03.01-12-0122/17",1);
insert into project (id, project_number, beneficiary_id) values (3,"RPMP.04.05.01-12-0422/17",2);
insert into project (id, project_number, beneficiary_id) values (4,"RPMP.06.03.01-12-0321/18",2);
insert into project (id, project_number, beneficiary_id) values (5,"RPMP.09.01.02-12-0092/18",2);
insert into project (id, project_number, beneficiary_id) values (6,"RPMP.07.01.01-12-0652/17",3);
insert into project (id, project_number, beneficiary_id) values (7,"RPMP.13.01.01-12-0922/17",3);
# WNP
insert into payment_request (id, certificated, date_of_approval, funding, income_deducted, payment_request_number,
                             qualified_expenses,qualified_expenses_after_validation,total_expenses,project_ID) values
(1,1,"2017-01-01",10000,0,"RPMP.01.02.03-12-0012/16-001",15000,14000,22000,1);
insert into payment_request (id, certificated, date_of_approval, funding, income_deducted, payment_request_number,
                             qualified_expenses,qualified_expenses_after_validation,total_expenses,project_ID) values
(2,1,"2017-05-12",14000,0,"RPMP.01.02.03-12-0012/16-003",21000,17000,15000,1);
insert into payment_request (id, certificated, date_of_approval, funding, income_deducted, payment_request_number,
                             qualified_expenses,qualified_expenses_after_validation,total_expenses,project_ID) values
(3,1,"2017-12-01",50000,0,"RPMP.03.03.01-12-0122/17-002",80000,65000,53000,1);
insert into payment_request (id, certificated, date_of_approval, funding, income_deducted, payment_request_number,
                             qualified_expenses,qualified_expenses_after_validation,total_expenses,project_ID) values
(4,1,"2018-02-12",60000,0,"RPMP.03.03.01-12-0122/17-004",125000,85000,84000,1);
insert into payment_request (id, certificated, date_of_approval, funding, income_deducted, payment_request_number,
                             qualified_expenses,qualified_expenses_after_validation,total_expenses,project_ID) values
(5,1,"2018-04-22",45000,0,"RPMP.04.05.01-12-0422/17-002",80000,55000,54000,2);
insert into payment_request (id, certificated, date_of_approval, funding, income_deducted, payment_request_number,
                             qualified_expenses,qualified_expenses_after_validation,total_expenses,project_ID) values
(6,1,"2018-09-12",90000,0,"RPMP.04.05.01-12-0422/17-004",150000,75000,74000,2);
insert into payment_request (id, certificated, date_of_approval, funding, income_deducted, payment_request_number,
                             qualified_expenses,qualified_expenses_after_validation,total_expenses,project_ID) values
(7,1,"2018-11-12",37000,0,"RPMP.06.03.01-12-0321/18-003",65000,45000,40000,2);
insert into payment_request (id, certificated, date_of_approval, funding, income_deducted, payment_request_number,
                             qualified_expenses,qualified_expenses_after_validation,total_expenses,project_ID) values
(8,1,"2019-02-12",110000,0,"RPMP.09.01.02-12-0092/18-001",162000,91000,84000,2);
insert into payment_request (id, certificated, date_of_approval, funding, income_deducted, payment_request_number,
                             qualified_expenses,qualified_expenses_after_validation,total_expenses,project_ID) values
(9,1,"2018-01-12",550000,0,"RPMP.07.01.01-12-0652/17-001",1620000,650000,641000,3);
insert into payment_request (id, certificated, date_of_approval, funding, income_deducted, payment_request_number,
                             qualified_expenses,qualified_expenses_after_validation,total_expenses,project_ID) values
(10,1,"2018-12-18",750000,0,"RPMP.07.01.01-12-0652/17-004",1716000,980000,910000,3);
insert into payment_request (id, certificated, date_of_approval, funding, income_deducted, payment_request_number,
                             qualified_expenses,qualified_expenses_after_validation,total_expenses,project_ID) values
(11,1,"2017-12-12",234000,0,"RPMP.13.01.01-12-0922/17-003",310000,210000,200000,3);
insert into payment_request (id, certificated, date_of_approval, funding, income_deducted, payment_request_number,
                             qualified_expenses,qualified_expenses_after_validation,total_expenses,project_ID) values
(12,0,"2019-07-12",143000,0,"RPMP.13.01.01-12-0922/17-009",162000,121000,120000,3);
# Dokument podstawa stwierdzenia nieprawidlowści
insert into document_base_irregularity (id, name) values (1,"Informacja o wynikach weryfikacji wniosku o płatność");
insert into document_base_irregularity (id, name) values (2,"Informacja pokontrolna IOK");
insert into document_base_irregularity (id, name) values (3,"Raport końcowy z kontroli instytucji UE (np. KE, OLAF)");
insert into document_base_irregularity (id, name) values (4,"Inne");
# Rodzaje nieprawidłowości
insert into irregularity_types (id, name) values (1,"Wydatki niekwalifikowalne");
insert into irregularity_types (id, name) values (2,"Naruszenie PZP");
insert into irregularity_types (id, name) values (3,"Podejrzenie nadużycia finansowego");
insert into irregularity_types (id, name) values (4,"Zwrot zaliczki po terminie");
insert into irregularity_types (id, name) values (5,"Podwójne finansowanie");
insert into irregularity_types (id, name) values (6,"Zasada konkurencyjności");
insert into irregularity_types (id, name) values (7,"Inne");
insert into irregularity_types (id, name) values (8,"Naruszenie zasady konkurencyjności");
# Nieprawidłowości
insert into irregularity (id,CAHas_Ended,actual,caseID,closed_ByIB,closed_ByMA,contract_Reference_Number,
                          contracting_Institution_NIP,control_Reference_Number,created,date_Of_Irregularity,description,
                          detected_Before_Send_ToEC,notes,qualified_Expenses,reported_InIMS,total_Expenses,visible_ToCA,user_ID,
                          document_Base_Irregularity_ID, beneficiary_ID, project_ID) values (1,0,1,1,0,0,"brak","5327992747",
                                                                                             "KO.01/2019","2019-04-01","2017-09-01","Wybrano wykonawcę, którego oferta nie była najkorzystniejsza",
                                                                                             0,"brak",1000,0,1500,1,1,1,1,1);
insert into irregularity (id,CAHas_Ended,actual,caseID,closed_ByIB,closed_ByMA,contract_Reference_Number,
                          contracting_Institution_NIP,control_Reference_Number,created,date_Of_Irregularity,description,
                          detected_Before_Send_ToEC,notes,qualified_Expenses,reported_InIMS,total_Expenses,visible_ToCA,user_ID,
                          document_Base_Irregularity_ID, beneficiary_ID, project_ID) values (2,0,1,2,0,0,"brak","5327992747","KO.01/2019","2019-04-01",
                                                                                             "2017-11-12","Wybrano wykonawcę, którego oferta nie spełniała warunków w postępowaniu",0,"brak",
                                                                                             1100,0,1650,1,1,1,1,2);
insert into irregularity (id,CAHas_Ended,actual,caseID,closed_ByIB,closed_ByMA,contract_Reference_Number,
                          contracting_Institution_NIP,control_Reference_Number,created,date_Of_Irregularity,description,
                          detected_Before_Send_ToEC,notes,qualified_Expenses,reported_InIMS,total_Expenses,visible_ToCA,user_ID,
                          document_Base_Irregularity_ID, beneficiary_ID, project_ID) values (3,0,1,3,0,0,"brak","5281655504","KO.03/2019","2019-04-01",
                                                                                             "2017-11-12","Brak protokołu z postępowania",0,"brak",
                                                                                             5000,0,7000,1,1,1,2,3);
# Nieprawidłowości i WNP
insert into payment_request_irregularity_list (payment_Request_List_id,irregularity_List_id) values (1,1);
insert into payment_request_irregularity_list (payment_Request_List_id,irregularity_List_id) values (2,1);
insert into payment_request_irregularity_list (payment_Request_List_id,irregularity_List_id) values (5,2);
insert into payment_request_irregularity_list (payment_Request_List_id,irregularity_List_id) values (9,3);
insert into payment_request_irregularity_list (payment_Request_List_id,irregularity_List_id) values (11,3);
insert into payment_request_irregularity_list (payment_Request_List_id,irregularity_List_id) values (12,3);
# Nieprawidłowości i ich rodzaj
insert into irregularity_types_irregularity_list (irregularity_Types_List_id,irregularity_List_id) values (1,1);
insert into irregularity_types_irregularity_list (irregularity_Types_List_id,irregularity_List_id) values (2,1);
insert into irregularity_types_irregularity_list (irregularity_Types_List_id,irregularity_List_id) values (1,2);
insert into irregularity_types_irregularity_list (irregularity_Types_List_id,irregularity_List_id) values (2,2);
insert into irregularity_types_irregularity_list (irregularity_Types_List_id,irregularity_List_id) values (1,3);
insert into irregularity_types_irregularity_list (irregularity_Types_List_id,irregularity_List_id) values (2,3);
