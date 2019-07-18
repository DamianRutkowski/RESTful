/**
 * Created by Damiann on 2015-10-18.
 */

var app = angular.module("mainApp", ['ui.router', 'ui.bootstrap', 'ngResource']);

app.factory("Article", function ($resource) {
    return $resource('/api/articles/:tagName', {tagName: '@tagName'}, {
        update: {
            method: 'PUT'
        }
    });
});

app.factory("ArticleComment", function ($resource) {
    return $resource('/api/article-comments/:id', {id: '@id'}, {
        update: {
            method: 'PUT'
        }
    });
});

app.factory('Auction', function ($resource) {
    return $resource('/api/auctions/:id', {id: '@id'}, {
        update: {
            method: 'PUT'
        }
    });
});

app.factory('AuctionCategory', function ($resource) {
    return $resource('/api/auction-categories/:id', {id: '@id'}, {
        update: {
            method: 'PUT'
        }
    });
});

app.factory('AuctionOrder', function ($resource) {
    return $resource('/api/auction-orders/:id', {id: '@id'}, {
        update: {
            method: 'PUT'
        }
    });
});

app.factory("Weapon", function ($resource) {
    return $resource('/api/weapons/:tagName', {tagName: '@tagName'}, {
        update: {
            method: 'PUT'
        }
    });
});

app.factory('PrivateMessage', function ($resource) {
    return $resource('/api/private-messages/:id', {id: '@id'}, {
        update: {
            method: 'PUT'
        }
    });
});

app.factory('UserMessage', function ($resource) {
    return $resource('/api/user-messages/:id', {id: '@id'}, {
        update: {
            method: 'PUT'
        }
    });
});

app.factory("WeaponComment", function ($resource) {
    return $resource('/api/weapon-comments/:id', {id: '@id'}, {
        update: {
            method: 'PUT'
        }
    });
});

app.factory("ForumCategory", function ($resource) {
    return $resource("/api/forum-categories/:id", {id: "@id"}, {
        update: {
            method: 'PUT'
        }
    })
});

app.factory("ForumSubcategory", function ($resource) {
    return $resource("/api/forum-subcategories/:tagName", {tagName: "@tagName"}, {
        update: {
            method: 'PUT'
        }
    })
});

app.factory("WeaponCategory", function ($resource) {
    return $resource("/api/weapon-categories/:id", {id: "@id"}, {
        update: {
            method: 'PUT'
        }
    });
});

app.factory("Thread", function ($resource) {
    return $resource('/api/threads/:id', {id: '@id'}, {
        update: {
            method: 'PUT'
        }
    });
});

app.factory('SubcategoryThreads', function ($resource) {
    return $resource('/api/forum-subcategories/:tagName/threads', {tagName: '@tagName'}, {
        get: {
            method: 'GET',
            isArray: true
        }
    });
});

app.factory("Post", function ($resource) {
    return $resource('/api/posts/:id', {id: '@id'}, {
        update: {
            method: 'PUT'
        }
    });
});

app.factory("User", function ($resource) {
    return $resource('/api/users/:username', {username: '@username'}, {
        update: {
            method: 'PUT'
        }
    });
});

app.factory('Role', function ($resource) {
    return $resource('/api/roles');
});

app.factory("Employee", function ($resource) {
    return $resource('/api/employees/:username', {username: '@username'}, {
        update: {
            method: 'PUT'
        }
    });
});