jQuery(document).ready(function ($) {

    var token = $('#_csrf').attr('content');
    var header = $('#_csrf_header').attr('content');

    $("#type-component").change(function (){

        let val = $(this).val();
        let table = $("#components");
        $.ajax({
            url: "/" + val,
            method: 'post',
            data: {
                "_csrf": token
            },
            success: (function (data){
                table.empty();
                let thead = `<thead><tr>`;
                let keys = Object.keys(data['type_component']['fields']);
                keys.forEach(element => thead += `<th scope="col">${data['type_component']['fields'][element]['value']}</th>`)
                thead += `<th></th><th></th></tr></thead>`;

                let tbody = `<tbody>`
                let tbodyElements = [];

                for(let i = 0; i < data['type_component']['components'].length; i++) {
                    let tbodyKeys = Object.keys(data['type_component']['components'][i]);
                    let tempElement = "<tr>"
                    tbodyKeys.forEach(element => {
                        if(element !== "_id") tempElement += `<th scope="col">${data['type_component']['components'][i][element]}</th>`
                    });
                    tempElement += `
                    <th scope="col">
                        <button id="${data['type_component']['components'][i]['_id']}" class="btn-sm custom-button edit-button">Обновить</button></th>
                    </th>
                    <th scope="col">
                        <button id="${data['type_component']['components'][i]['_id']}" class="btn-sm custom-button remove-button">Удалить</button></th>
                    </th></tr>`
                    tbodyElements.push(tempElement);
                }
                tbody += tbodyElements + "</tbody>";
                table.append(thead);
                table.append(tbody);
                resize_table_box();
            })
        });
    });

    $("#item-search").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#table-components tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });


    function resize_table_box() {
        $('.big-table').each(function(){
            var box_width = $(this).outerWidth();
            var table_width = $(this).children('table').prop('scrollWidth');
            $(this).removeClass('scroll-left');
            if (table_width > box_width) {
                $(this).addClass('scroll-right');
            } else {
                $(this).removeClass('scroll-right');
            }
        });
    }

    resize_table_box();
    $( window ).on('resize', function() {
        resize_table_box();
    });

    $('.big-table table').on('scroll', function() {
        var parent = $(this).parent();
        if ($(this).scrollLeft() + $(this).innerWidth() >= $(this)[0].scrollWidth) {
            if (parent.hasClass('scroll-right') ){
                parent.removeClass('scroll-right');
            }
        } else if ($(this).scrollLeft() === 0){
            if (parent.hasClass('scroll-left')){
                parent.removeClass('scroll-left');
            }
        } else {
            if(!parent.hasClass('scroll-right')){
                parent.addClass('scroll-right');
            }
            if(!parent.hasClass('scroll-left')){
                parent.addClass('scroll-left');
            }
        }
    });
});