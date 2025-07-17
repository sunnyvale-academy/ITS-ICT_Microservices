

#!/usr/bin/env bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
   -- Create user
  CREATE USER microservice WITH PASSWORD 'microservice';

  -- Create schema
  CREATE SCHEMA microservice AUTHORIZATION microservice;

  -- Create customers table in schema
  CREATE TABLE microservice.customers (
        id serial primary key,
        name varchar(100) not null,
        email varchar(100) not null unique,
        phone varchar(15),
        address text
   );

  -- Grant full access to user on schema, tables, and sequences
  GRANT ALL PRIVILEGES ON SCHEMA microservice TO microservice;
  GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA microservice TO microservice;

  -- Insert sample data
  INSERT INTO microservice.customers (id, name, email, phone, address) VALUES
        (1, 'John Doe', 'john.doe@oracle.com', '1234567890', '123 Oracle St, Redwood City, CA'),
        (2, 'Jane Smith', 'jane.smith@microsoft.com', '0987654321', '456 Microsoft Ave, Redmond, WA'),
        (3, 'Alice Johnson', 'alice.johnson@google.com', '1122334455', '789 Google Blvd, Mountain View, CA');
    
EOSQL