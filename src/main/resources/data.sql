insert into equipment_type_ent (id, betta, equipment_type) values (1, 0.0001, 'transformer');
insert into equipment_type_ent (id, betta, equipment_type) values (2, 0.0001, 'breaker');
insert into equipment_type_ent (id, betta, equipment_type) values (3, 0.0001, 'cable_line');
insert into equipment_type_ent (id, betta, equipment_type) values (4, 0.0001, 'air_line');

insert into equipment_ent (id, last_fixion_date, mrid,equip_type_id) values (1, '2/11/2017', 'TR_1',1);
insert into equipment_ent (id, last_fixion_date, mrid,equip_type_id) values (2, '2/11/2017', 'TR_2',1);
insert into equipment_ent (id, last_fixion_date, mrid,equip_type_id) values (3, '2/11/2017', 'AL_1',4);
insert into equipment_ent (id, last_fixion_date, mrid,equip_type_id) values (4, '2/11/2017', 'BR_1',2);
insert into equipment_ent (id, last_fixion_date, mrid,equip_type_id) values (5, '2/11/2017', 'CL_1',3);


insert into alpha_params_ent (id, p1, p2, p3,equipment_id,alpha) values (1, 0.001, 0.002,0.003,1,0.005);
insert into alpha_params_ent (id, p1, p2, p3,equipment_id,alpha) values (2, 0.001, 0.002,0.003,2,0.005);
insert into alpha_params_ent (id, p1, p2, p3,equipment_id,alpha) values (3, 0.001, 0.002,0.003,3,0.005);
insert into alpha_params_ent (id, p1, p2, p3,equipment_id,alpha) values (4, 0.001, 0.002,0.003,4,0.005);
insert into alpha_params_ent (id, p1, p2, p3,equipment_id,alpha) values (5, 0.001, 0.002,0.003,5,0.005);


insert into its_measurements_postgres_version (id, equipment_id, its, measurment_date) values (1, 1, 100, '1/11/2017');
insert into its_measurements_postgres_version (id, equipment_id, its, measurment_date) values (2, 1, 100, '2/11/2017');
insert into its_measurements_postgres_version (id, equipment_id, its, measurment_date) values (3, 1, 100, '3/11/2017');
insert into its_measurements_postgres_version (id, equipment_id, its, measurment_date) values (4, 1, 100, '4/11/2017');
insert into its_measurements_postgres_version (id, equipment_id, its, measurment_date) values (5, 1, 100, '5/11/2017');
insert into its_measurements_postgres_version (id, equipment_id, its, measurment_date) values (6, 1, 100, '6/11/2017');

insert into predicted_its_meas (id, pred_date, its, plan_number,equipment_id) values (1, '10/11/2017', 100, 1,1);
insert into predicted_its_meas (id, pred_date, its, plan_number,equipment_id) values (2, '11/11/2017', 99, 1,1);
insert into predicted_its_meas (id, pred_date, its, plan_number,equipment_id) values (3, '12/11/2017', 98, 1,1);
insert into predicted_its_meas (id, pred_date, its, plan_number,equipment_id) values (4, '13/11/2017', 97, 1,1);
insert into predicted_its_meas (id, pred_date, its, plan_number,equipment_id) values (5, '14/11/2017', 96, 1,1);
insert into predicted_its_meas (id, pred_date, its, plan_number,equipment_id) values (6, '15/11/2017', 95, 1,1);
insert into predicted_its_meas (id, pred_date, its, plan_number,equipment_id) values (7, '16/11/2017', 94, 1,1);
insert into predicted_its_meas (id, pred_date, its, plan_number,equipment_id) values (8, '17/11/2017', 98, 1,1);
insert into predicted_its_meas (id, pred_date, its, plan_number,equipment_id) values (9, '18/11/2017', 97, 1,1);
insert into predicted_its_meas (id, pred_date, its, plan_number,equipment_id) values (10, '19/11/2017', 96, 1,1);