$(document).ready(function() {

  $.widget("custom.superAuto", $.ui.autocomplete, {
// options : {
// classes : {
// "ui-autocomplete" : "custom-ui-autocomplete"
// }
// },
    _renderMenu : function(ul, items) {
      var self = this;
//      ul.append("<div><span id='products'>KOSSSS</span></div>");
      $.each(items, function(index, item) {
        self._renderItem(ul, item);
      });
    },
    _renderItem : function(column, item) {

      var renderHtml = "<div class='ui-menu-item-wrapper'>";
      renderHtml += item.postcode + " " + item.locality;
      renderHtml += "</div>";
      return $("<li class='ui-menu-item'>").attr("data-value", item.id).append(renderHtml).appendTo(column);
    }

  });

  
// var addressData = [];
// $.getJSON('/postcode-data/au_codes.json', function(data) {
// addressData = data;
// });

  $("#autocomplete").autocomplete({
    minLength : 2,
    source : function(request, response) {
      
// var matcher = new RegExp( "^" + request.term , "i" );
// response( $.grep( addressData, function( item ){
// return matcher.test( item.PostCode ) || matcher.test( item.Suburb );
// }) );
      
      
      $.get(encodeURI("/api/v1/search/" + request.term), function(data) {
        
        var list = []
        data.forEach(function(item) {
          list.push({'value': item.postcode, 'label': item.locality + ' ' + item.postcode});
        })
        response(list);
//        response(data);
      });
    }, 
    select: function(event, ui){
      console.log(event);
      console.log(ui);
    } 
    

  });

});
