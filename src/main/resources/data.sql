insert into equipment_type_ent (id, betta, equipment_type) values (1, 0.0001, 'transformer');
insert into equipment_type_ent (id, betta, equipment_type) values (2, 0.0001, 'breaker');
insert into equipment_type_ent (id, betta, equipment_type) values (3, 0.0001, 'cable_line');
insert into equipment_type_ent (id, betta, equipment_type) values (4, 0.0001, 'air_line');

insert into equipment_ent (id, last_fixion_date, mrid,equip_type_id) values (1, '2017/11/27', 'TR_1',1);
insert into equipment_ent (id, last_fixion_date, mrid,equip_type_id) values (2, '2017/11/27', 'TR_2',1);
insert into equipment_ent (id, last_fixion_date, mrid,equip_type_id) values (3, '2017/11/27', 'AL_1',4);
insert into equipment_ent (id, last_fixion_date, mrid,equip_type_id) values (4, '2017/11/27', 'BR_1',2);
insert into equipment_ent (id, last_fixion_date, mrid,equip_type_id) values (5, '2017/11/27', 'CL_1',3);


insert into alpha_params_ent (id, p1, p2, p3,equipment_id) values (1, 0.001, 0.002,0.003,1);
insert into alpha_params_ent (id, p1, p2, p3,equipment_id) values (2, 0.001, 0.002,0.003,2);
insert into alpha_params_ent (id, p1, p2, p3,equipment_id) values (3, 0.001, 0.002,0.003,3);
insert into alpha_params_ent (id, p1, p2, p3,equipment_id) values (4, 0.001, 0.002,0.003,4);
insert into alpha_params_ent (id, p1, p2, p3,equipment_id) values (5, 0.001, 0.002,0.003,5);


insert into its_measurements_postgres_version (id, equipment_id, measured_value, measurment_date) values (1, 1, 100, '2017/11/20');
insert into its_measurements_postgres_version (id, equipment_id, measured_value, measurment_date) values (2, 1, 100, '2017/11/21');
insert into its_measurements_postgres_version (id, equipment_id, measured_value, measurment_date) values (3, 1, 100, '2017/11/29');
insert into its_measurements_postgres_version (id, equipment_id, measured_value, measurment_date) values (4, 1, 100, '2017/11/30');
insert into its_measurements_postgres_version (id, equipment_id, measured_value, measurment_date) values (5, 1, 100, '2017/12/1');
insert into its_measurements_postgres_version (id, equipment_id, measured_value, measurment_date) values (6, 1, 100, '2017/12/2');