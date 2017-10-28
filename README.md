# androidfoldersplugin
quick cordova plugin to get android special folders path

## Installation:
cordova plugin add https://github.com/nicolasgrolleau/androidfoldersplugin

## Usage:
    androidfoldersplugin.getDirectories(function(result){
            //receive a json object containing all the folders
            console.log("All the folders:"+JSON.stringify(result));
            console.log("Download folder"+result["Download"]);
        },
        function(error){
            alert("Error:"+error);
        }
    );
