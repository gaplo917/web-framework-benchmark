function createMultiSeries(opt){
    const {id, title, dataUrl, xAxisTitle, yAxisTitle, pathOnly, dotted} = opt

    const svg = d3.select(id)
    const margin = {top: 20, right: 80, bottom: 30, left: 50}
    const width = svg.attr("width") - margin.left - margin.right
    const height = svg.attr("height") - margin.top - margin.bottom
    const g = svg.append("g").attr("transform", "translate(" + margin.left + "," + margin.top + ")")

    svg.append("text")
        .attr("x", (width / 2) + margin.left * 2)
        .attr("y", margin.top)
        .attr("text-anchor", "middle")
        .style("font-size", "16px")
        .style("text-decoration", "underline")
        .style("stroke-dasharray", ("3, 3"))
        .text(pathOnly ? '' : title);

    const x = d3.scaleLinear().range([0, width]),
        y = d3.scaleLinear().range([height, 0]),
        z = d3.scaleOrdinal(d3.schemeCategory10);

    const line = d3.line()
        .curve(d3.curveBasis)
        .x(function(d) { return x(d.xValue); })
        .y(function(d) { return y(d.yValue); });

    d3.json(dataUrl, function(error, data) {
        if (error) throw error;

        const frameworks = data.map(function(dataum, index) {
            return {
                id: dataum.value,
                values: Object.keys(dataum)
                    .filter((key) => { return key !== "value" && parseInt(dataum[key]) >= 0 })
                    .map(function(key) {
                        return {xValue: parseInt(key), yValue: parseInt(dataum[key])};
                    })
            };
        });

        x.domain([
            d3.min(frameworks, function(c) { return d3.min(c.values, function(d) { return d.xValue; }); }),
            d3.max(frameworks, function(c) { return d3.max(c.values, function(d) { return d.xValue; }); })
        ]);

        y.domain([
            d3.min(frameworks, function(c) { return d3.min(c.values, function(d) { return d.yValue; }); }),
            d3.max(frameworks, function(c) { return d3.max(c.values, function(d) { return d.yValue; }); })
        ]).nice();

        z.domain(frameworks.map(function(c) { return c.id; }));

        if(!pathOnly){
            g.append("g")
                .attr("transform", "translate(0," + height + ")")
                .call(d3.axisBottom(x))
                .append("text")
                .attr("x", width)
                .attr("dx", "-2.0em")
                .attr("dy", "2.5em")
                .attr("fill", "#000")
                .text(xAxisTitle)

            g.append("g")
                .attr("class", "axis axis--y")
                .call(d3.axisLeft(y))
                .append("text")
                .attr("transform", "rotate(-90)")
                .attr("y", 6)
                .attr("dy", "0.7em")
                .attr("fill", "#000")
                .text(yAxisTitle);
        }

        const framework = g.selectAll(".framework")
            .data(frameworks)
            .enter().append("g")
            .attr("class", "framework");

        const path = framework.append("path")
            .attr("class", "line")
            .attr("d", function(d) { return line(d.values); })
            .style("stroke", function(d) { return z(d.id); });

        if(dotted) {
            path.style("stroke-dasharray", ("3, 3"))
        }

        framework.append("text")
            .datum(function(d) { return {id: d.id, value: d.values[d.values.length - 1]}; })
            .attr("transform", function(d) { return "translate(" + x(d.value.xValue) + "," + y(d.value.yValue) + ")"; })
            .attr("x", 3)
            .attr("dy", "0.35em")
            .style("font", "10px sans-serif")
            .text(function(d) { return d.id; });
    });
}
