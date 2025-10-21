-- Migration Flyway: initialisation des tables principales pour Travel Buddy Split
-- Fichier: src/main/resources/db/migration/V1__init.sql

-- USERS
create table users (
  id bigserial primary key,
  email varchar(255) not null unique,
  password_hash varchar(255) not null,
  display_name varchar(120) not null
);

-- TRIPS
create table trips (
  id bigserial primary key,
  name varchar(140) not null,
  start_date date,
  end_date date,
  owner_id bigint not null references users(id)
);
create index idx_trip_owner on trips(owner_id);

-- TRIP MEMBERS (User <-> Trip)  N–N avec attributs
create table trip_member (
  id bigserial primary key,
  trip_id bigint not null references trips(id) on delete cascade,
  user_id bigint not null references users(id) on delete cascade,
  role varchar(20) not null default 'EDITOR', -- OWNER|EDITOR|VIEWER
  unique (trip_id, user_id)
);
create index idx_trip_member_trip on trip_member(trip_id);
create index idx_trip_member_user on trip_member(user_id);

-- ACTIVITIES (Trip 1–N Activity)
create table activities (
  id bigserial primary key,
  trip_id bigint not null references trip(id) on delete cascade,
  title varchar(180) not null,
  start_at timestamptz,
  end_at timestamptz,
  location varchar(255),
  notes text
);
create index idx_activity_trip on activities(trip_id);

-- ACCOMODATIONS (Trip 1–N Accomodation)
create table accomodations (
  id bigserial primary key,
  trip_id bigint not null references trip(id) on delete cascade,
  name varchar(180) not null,
  address text,
  check_in timestamptz,
  check_out timestamptz,
  notes text
);
create index idx_accomodation_trip on accomodations(trip_id);

-- EXPENSES (Trip 1–N Expense ; User N–1 payer)
create table expenses (
  id bigserial primary key,
  trip_id bigint not null references trip(id) on delete cascade,
  payer_id bigint not null references users(id),
  title varchar(180) not null,
  amount numeric(12,2) not null check (amount >= 0),
  notes text
);
create index idx_expense_trip on expense(trip_id);
create index idx_expense_payer on expense(payer_id);

-- EXPENSE SHARES (Expense N–N User avec attribut share_amount)
create table expense_share (
  id bigserial primary key,
  expense_id bigint not null references expense(id) on delete cascade,
  user_id bigint not null references users(id) on delete cascade,
  share_amount numeric(12,2) not null check (share_amount >= 0)
);
create index idx_share_expense on expense_share(expense_id);
create index idx_share_user on expense_share(user_id);


