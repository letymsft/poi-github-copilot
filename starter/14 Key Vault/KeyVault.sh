secret=$(az keyvault secret show --name mysecret --vault-name mykeyvault --query value -o tsv)
echo "The secret value is: $secret"