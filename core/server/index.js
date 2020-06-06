//Belum tepakek
const table = document.querySelector("#result")
const search = document.querySelector("#search");

search.addEventListener("change", res => {
    fetch(`http://localhost/projek-sda/core/data/json.php?q=${res.target.value}`)
        .then((response) => {
            return response.json();
        })
        .then(res => {
            if (res.length !== 0)
                table.innerHTML = result(res)
            else
                table.innerHTML = `<thead>
                <th scope="col"class="text-center"> No Result </th>
                </thead>`
        })
    res.preventDefault()
})

let result = datas => {
    let result = `
    <thead>
        <tr>
            <th scope="col">No</th> 
            <th scope="col">Name</th>
            <th scope="col">Edited Article</th> 
        </tr> 
    </thead>
    <tbody>`
    datas.forEach((data, index) => {
        result +=
            `<tr>
            <th scope = "row">${index+1}</th> 
            <td>${data.editor}</td> 
            <td>${data.freq}</td>
            </tr > `
    });
    result += `</tbody>`
    return result
}