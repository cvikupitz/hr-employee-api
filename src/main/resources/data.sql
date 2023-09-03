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

insert into employee_types (_ID, TITLE, UPDATE_USER_ID, UPDATE_TS) values
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

insert into employee_titles (_ID, TITLE, ABBREVIATION, UPDATE_USER_ID, UPDATE_TS) values
  (401, 'Chief Executive Officer', 'CEO', @UpdateUserId, @UpdateTs),
  (402, 'Chief Operating Officer', 'COO', @UpdateUserId, @UpdateTs),
  (403, 'Chief Financial Officer', 'CFO', @UpdateUserId, @UpdateTs),
  (404, 'Chief Technology Officer', 'CTO', @UpdateUserId, @UpdateTs),
  (405, 'Chief Marketing Officer', 'CMO', @UpdateUserId, @UpdateTs),
  (406, 'Chief Legal Officer', 'CLO', @UpdateUserId, @UpdateTs);