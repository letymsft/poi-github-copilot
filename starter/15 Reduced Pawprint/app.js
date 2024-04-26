const express = require('express');
const msRestAzure = require('ms-rest-azure');
const resourceManagement = require('azure-arm-resource');

let credentials;
let subscriptionId = 'your-subscription-id'; // replace with your Azure Subscription ID
let resourceClient;

msRestAzure.interactiveLogin().then((creds) => {
  credentials = creds;
  resourceClient = new resourceManagement.ResourceManagementClient(credentials, subscriptionId);
});

const app = express();

app.get('/', async (req, res) => {
  const result = await resourceClient.resourceGroups.list();
  res.send(result);
});

app.get('/delete/:resourceGroupName', async (req, res) => {
  const resourceGroupName = req.params.resourceGroupName;
  const result = await resourceClient.resourceGroups.deleteMethod(resourceGroupName);
  res.send(`Resource group ${resourceGroupName} deleted.`);
});

app.listen(3000, () => console.log('App listening on port 3000!'));