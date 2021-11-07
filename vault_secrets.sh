export VAULT_ADDR=http://localhost:8200
vault login vault_dev_token
cd product-service || exit
vault kv put secret/product-service @product-service.json
cd ../order-service || exit
vault kv put secret/order-service @order-service.json
cd ../inventory-service || exit
vault kv put secret/inventory-service @inventory-service-credentials.json
