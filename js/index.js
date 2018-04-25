const cheeseList = require('cheese-list');
const cheeseTest = RegExp('^Q\\d+');
cheeseList.map(cheese => cheese.itemLabel)
    .filter(cheese => !cheeseTest.test(cheese))
    .sort()
    .forEach(cheese => console.log(cheese));