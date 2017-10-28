var exec = require('cordova/exec');

var androidfoldersplugin={
	getDirectories: function(win,fail){
		exec(win, fail, "AndroidFoldersPlugin","getDirectories", []);
	}
};

module.exports = androidfoldersplugin;