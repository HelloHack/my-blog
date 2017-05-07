angular.module('postDetail')
       .component('postDetail', {
            templateUrl: "static/js/post-detail/post-detail.template.html",
            controller: ['$routeParams', 'postDetail',
                function postDetailController($routeParams, postDetail) {
                    var self = this;
                    postDetail.get({name:$routeParams.name},
                                     function(detail) {
                                        self.entity = detail.entity;
                                        self.content = detail.content;
                                    });
                }
            ]
       });