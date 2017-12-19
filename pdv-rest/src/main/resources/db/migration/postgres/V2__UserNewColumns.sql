ALTER TABLE PUBLIC.saa_usuario
add column tx_authorities VARCHAR(255)  default 'ADMIN',
ADD COLUMN bl_account_non_expired BOOLEAN  DEFAULT true,
ADD COLUMN bl_account_non_locket BOOLEAN  default true,
ADD COLUMN bl_credential_non_expired BOOLEAN  default true,
ADD COLUMN bl_enabled BOOLEAN  default true ;

