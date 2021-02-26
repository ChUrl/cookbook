module.exports = {
    purge: {
        // Should contain every file that references used css classes
        content: ['./src/main/resources/**/*.html'],

        // !: Tailwind only purges when NODE_ENV is set to production
    },
    theme: {
        extend: {}
    },
    variants: {
        extend: {
            padding: ['active', 'hover', 'focus'],
            margin: ['active', 'hover', 'focus'],
            boxShadow: ['active', 'hover', 'focus'],
            scale: ['active', 'hover', 'focus'],
            textColor: ['active', 'hover', 'focus'],
            backgroundColor: ['active', 'hover', 'focus'],
            borderColor: ['active', 'hover', 'focus']
        }
    },
    plugins: []
}
