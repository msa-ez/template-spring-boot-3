forEach: View
fileName: {{namePascalCase}}Repository.java
path: {{boundedContext.name}}/{{{options.packagePath}}}/infra
mergeType: template
except: {{contexts.isNotCQRS}}

---
package {{options.package}}.infra;

import {{options.package}}.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="{{namePlural}}", path="{{namePlural}}")
public interface {{namePascalCase}}Repository extends JpaRepository<{{namePascalCase}}, Long> {

    {{#setFindBy updateRules namePascalCase}}{{/setFindBy}}

    {{#setDeleteBy deleteRules namePascalCase}}{{/setDeleteBy}}
}

<function>

var me = this;
this.boundedContext.aggregates.forEach(agg => {if(agg.name==me.name) me.aggregate = agg});

this.contexts.isNotCQRS = (this.dataProjection != "cqrs")

window.$HandleBars.registerHelper('setFindBy', function (updateRules, name) {
    var text = "";
    try {
        if(updateRules.length > 0) {
            updateRules.forEach(function(rule) {
                if(rule.where.length > 0) {
                    rule.where.forEach(function(obj) {
                        if(!text.includes("findBy" + obj.viewField.namePascalCase)) {
                            if(!obj.viewField.isKey) {
                                text += "List<" + name + "> findBy" + obj.viewField.namePascalCase + "(" + obj.viewField.className + " " + obj.viewField.nameCamelCase + ");\n";
                            }
                        }
                    });
                }
            });
        }
        return text;
    } catch(e) {
        console.log(e)
    }
});

window.$HandleBars.registerHelper('setDeleteBy', function (deleteRules) {
    var text = "";
    try {
        if(deleteRules.length > 0) {
            deleteRules.forEach(function(rule) {
                if(rule.where.length > 0) {
                    rule.where.forEach(function(obj) {
                        if(!text.includes("deleteBy" + obj.viewField.namePascalCase)) {
                            if(!obj.viewField.isKey) {
                                text += "void"  + " deleteBy" + obj.viewField.namePascalCase + "(" + obj.viewField.className + " " + obj.viewField.nameCamelCase + ");\n";
                            }
                        }
                    });
                }
            });
        }
        return text;
    } catch(e) {
        console.log(e)
    }
});
</function>
